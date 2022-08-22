package aula18_maven.mesa.dao.impl;

import aula15.model.Paciente;
import aula18_maven.mesa.dao.IDao;
import aula18_maven.mesa.dao.config.ConfiguracaoJDBC;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacienteDaoH2 implements IDao<Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = Logger.getLogger(PacienteDaoH2.class);

    public PacienteDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        log.info("Cadastrando paciente: " + paciente.toString());

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("INSERT INTO paciente (nome, sobrenome, rg, dataCadastro, idEndereco) VALUES ('%s', '%s', '%s', '%s', '%s')", paciente.getNome(), paciente.getSobrenome(), paciente.getRg(), paciente.getDataCadastro(), paciente.getIdEndereco());

        try{
            st = c.createStatement();
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet keys = st.getGeneratedKeys();

            if (keys.next()){
                paciente.setId(keys.getInt(1));
            }
            st.close();
            c.close();
        } catch (SQLException e){
            log.error(e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        log.info("Buscando paciente nº " + id);

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("SELECT * FROM paciente WHERE id = '%s'", id);

        Paciente paciente = null;

        try{
            st = c.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6));
            }
            st.close();
            c.close();
        } catch (SQLException e){
            log.error(e.getMessage());
        }
        return paciente;
    }

    @Override
    public void deletar(Integer id) {
        log.info("Excluindo paciente nº " + id);

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("DELETE FROM paciente WHERE id = '%s'", id);

        try{
            st = c.createStatement();
            st.execute(query);

            log.info("Paciente excluído");
        } catch (SQLException e){
            log.error(e.getMessage());
        }
    }
}
