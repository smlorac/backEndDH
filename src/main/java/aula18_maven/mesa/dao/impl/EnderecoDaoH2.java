package aula18_maven.mesa.dao.impl;

import aula18_maven.mesa.dao.IDao;
import aula18_maven.mesa.dao.config.ConfiguracaoJDBC;
import aula18_maven.mesa.model.Endereco;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoDaoH2 implements IDao<Endereco> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = Logger.getLogger(EnderecoDaoH2.class);

    public EnderecoDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }


    @Override
    public Endereco salvar(Endereco endereco) {
        log.info("Cadastrando endereço: " + endereco.toString());

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("INSERT INTO endereco (rua, numero, cidade, bairro) VALUES ('%s', '%s', '%s', '%s')", endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getBairro());

        try{
            st = c.createStatement();
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet keys = st.getGeneratedKeys();

            if (keys.next()){
                endereco.setId(keys.getInt(1));
            }
            st.close();
            c.close();
        } catch (SQLException e){
            log.error(e.getMessage());
        }
        return endereco;
    }

    @Override
    public Endereco buscar(Integer id) {
        log.info("Buscando paciente nº " + id);

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("SELECT * FROM paciente WHERE id = '%s'", id);

        Endereco endereco = null;

        try{
            st = c.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                endereco = new Endereco(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            }
            st.close();
            c.close();
        } catch (SQLException e){
            log.error(e.getMessage());
        }
        return endereco;
    }

    @Override
    public void deletar(Integer id) {
        log.info("Excluindo endereço nº " + id);

        Connection c = configuracaoJDBC.conectar();
        Statement st = null;

        String query = String.format("DELETE FROM endereco WHERE id = '%s'", id);

        try{
            st = c.createStatement();
            st.execute(query);

            log.info("Endereço excluído");
        } catch (SQLException e){
            log.error(e.getMessage());
        }
    }
}
