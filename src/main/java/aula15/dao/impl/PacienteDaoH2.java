package aula15.dao.impl;

import aula14_padraoDAO.aula.dao.ConfiguracaoJDBC;
import aula15.dao.IDao;
import aula15.model.Paciente;
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
    public Paciente salvar(Paciente paciente) throws SQLException{
        Connection connection = configuracaoJDBC.conectar();
        Statement st = null;
        String query = String.format("INSERT INTO pacientes (nome, sobrenome, rg, dataCadastro, idEndereco) VALUES ('%s', '%s', '%s', '%s', '%s')", paciente.getNome(), paciente.getSobrenome(), paciente.getRg(), paciente.getDataCadastro(), paciente.getIdEndereco());

        try {
            st = connection.createStatement();
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = st.getGeneratedKeys();

            if (keys.next()){
                paciente.setId(keys.getInt(1));
            }
            st.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) throws SQLException{
        Connection connection = configuracaoJDBC.conectar();
        Statement statement = null;
        String query = String.format("SELECT * FROM pacientes WHERE id = '%s'", id);

        Paciente paciente = null;

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                paciente = new Paciente(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5), rs.getInt(6));
            }

            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void excluir(Integer id) throws SQLException{
        Connection connection = configuracaoJDBC.conectar();
        Statement statement = null;
        String query = String.format("DELETE FROM pacientes WHERE id = '%s'", id);

        Paciente paciente = null;

        try{
            statement = connection.createStatement();

            statement.execute(query);

            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        statement.close();
        connection.close();
    }
}
