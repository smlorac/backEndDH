package aula15.dao.impl;

import aula14_padraoDAO.aula.dao.ConfiguracaoJDBC;
import aula15.dao.IDao;
import aula15.model.Endereco;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoDaoH2 implements IDao<Endereco> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = Logger.getLogger(PacienteDaoH2.class);

    public EnderecoDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Endereco salvar(Endereco endereco) throws SQLException {
        Connection connection = configuracaoJDBC.conectar();
        Statement st = null;
        String query = String.format("INSERT INTO enderecos (rua, numero, cidade, bairro) VALUES ('%s', '%s', '%s', '%s')", endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getBairro());

        try {
            st = connection.createStatement();
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = st.getGeneratedKeys();

            if (keys.next()){
                endereco.setId(keys.getInt(1));
            }
            st.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Endereco buscar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void excluir(Integer id) throws SQLException {

    }
}
