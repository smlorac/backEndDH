package aula14_padraoDAO.aula.dao.impl;

import aula14_padraoDAO.aula.dao.ConfiguracaoJDBC;
import aula14_padraoDAO.aula.dao.IDAO;
import aula14_padraoDAO.aula.model.Medicamento;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicamentoDAOH2 implements IDAO<Medicamento> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = Logger.getLogger(MedicamentoDAOH2.class);

    public MedicamentoDAOH2(ConfiguracaoJDBC configuracaoJDBC){
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Medicamento salvar(Medicamento medicamento) {

        log.info("Registrando novo medicamento: " + medicamento.toString());

        Connection connection = configuracaoJDBC.conectar();
        Statement statement = null;
        String query = String.format("INSERT INTO medicamentos(nome, laboratorio, quantidade, preco) VALUES ('%s, '%s', '%s', '%s')", medicamento.getNome(), medicamento.getLaboratorio(), medicamento.getQuantidade(), medicamento.getPreco());
        //o %s é tipo um placeholder indicando que algo será adicionado nesse parametro

        try{
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()){
                medicamento.setId(keys.getInt(1));

                statement.close();
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {
        log.info("Buscando medicamento com id " + id);

        Connection connection = configuracaoJDBC.conectar();
        Statement statement = null;
        String query = String.format("SELECT * FROM medicamentos WHERE id = '%s'", id);

        Medicamento medicamento = null;

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                medicamento = new Medicamento(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5));
            }

            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return medicamento;
    }
}
