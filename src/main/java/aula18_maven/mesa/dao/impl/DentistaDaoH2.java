package aula18_maven.mesa.dao.impl;

import aula18_maven.mesa.dao.IDao;
import aula18_maven.mesa.dao.config.ConfiguracaoJDBC;
import aula18_maven.mesa.model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DentistaDaoH2 implements IDao<Dentista> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = Logger.getLogger(DentistaDaoH2.class);

    public DentistaDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }


    @Override
    public Dentista salvar(Dentista dentista) {
        log.info("Cadastrando dentista: " + dentista.toString());

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("INSERT INTO dentista (sobrenome, nome, matricula) VALUES ('%s', '%s', '%s')", dentista.getSobrenome(), dentista.getNome(), dentista.getMatricula());

        try{
            st = c.createStatement();
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet keys = st.getGeneratedKeys();

            if (keys.next()){
                dentista.setId(keys.getInt(1));
            }
            st.close();
            c.close();
        } catch (SQLException e){
            log.error(e.getMessage());
        }
        return dentista;
    }

    @Override
    public Dentista buscar(Integer id) {
        log.info("Buscando dentista nº " + id);

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("SELECT * FROM dentista WHERE id = '%s'", id);

        Dentista dentista = null;

        try{
            st = c.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                dentista = new Dentista(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            st.close();
            c.close();
        } catch (SQLException e){
            log.error(e.getMessage());
        }
        return dentista;
    }

    @Override
    public void deletar(Integer id) {
        log.info("Excluindo dentista nº " + id);

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("DELETE FROM dentista WHERE id = '%s'", id);

        try{
            st = c.createStatement();
            st.execute(query);

            log.info("Dentista excluído");
        } catch (SQLException e){
            log.error(e.getMessage());
        }
    }
}
