package aula13_consultasETransacoes.aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {

    private static final String sqlCreate = "DROP TABLE IF EXISTS Conta;"
            +"CREATE TABLE Conta"
            +"("
            +"id INT PRIMARY KEY AUTO_INCREMENT,"
            +"nome VARCHAR(100) NOT NULL,"
            +"numeroConta VARCHAR(100) NOT NULL,"
            +"saldo NUMERIC(15,2)"
            +");";

    private static final String sqlInsert = "INSERT INTO Conta(nome, numeroConta, saldo) VALUES (?, ?, ?);";

    private static final String sqlUpdate = "UPDATE Conta SET saldo = ? WHERE id = ?";

    public static void main(String[] args) throws Exception{

        Conta conta = new Conta("Carol", "666", 150);

        Connection connection = null;

        try{
            connection = ConnectionJDBC.getConnection();

            Statement statement = connection.createStatement();
            statement.execute(sqlCreate);

            PreparedStatement preparedStatementInsert = connection.prepareStatement(sqlInsert);

            preparedStatementInsert.setString(2, conta.getNome());
            preparedStatementInsert.setString(3, conta.getNumConta());
            preparedStatementInsert.setDouble(4, conta.getSaldo());
            preparedStatementInsert.execute();

            PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);

            preparedStatementUpdate.setDouble(1, conta.aumentarSaldo(10));
            preparedStatementUpdate.setInt(2, conta.getId());
            preparedStatementUpdate.execute();

            connection.setAutoCommit(false);
            //commit do banco de dados

            PreparedStatement preparedStatementUpdate2 = connection.prepareStatement(sqlUpdate);

            preparedStatementUpdate2.setDouble(1, conta.aumentarSaldo(15));
            preparedStatementUpdate2.setInt(2, conta.getId());
            preparedStatementUpdate2.execute();

            connection.commit();
            //commitando, mas poderia só setar como true
            connection.setAutoCommit(true);
        } catch (Exception e){
            connection.rollback();
            //ou seja, se der erro, ele faz rollback para versão sem erro
        } finally {
            connection.close();
        }
    }
}
