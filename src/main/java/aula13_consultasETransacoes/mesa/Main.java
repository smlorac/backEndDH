package aula13_consultasETransacoes.mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String sqlCreate = "DROP TABLE IF EXISTS Dentista;"
            +"CREATE TABLE Dentista"
            +"("
            +"id INT PRIMARY KEY AUTO_INCREMENT,"
            +"sobrenome VARCHAR(300) NOT NULL,"
            +"nome VARCHAR(100) NOT NULL,"
            +"matricula VARCHAR(100)"
            +");";

    private static final String sqlInsert = "INSERT INTO Dentista(sobrenome, nome, matricula) VALUES (?, ?, ?);";

    private static final String sqlUpdate = "UPDATE Dentista SET matricula = ? WHERE sobrenome = ?";

    private static final String sqlSelect = "SELECT * FROM Dentista;";

    public static void main(String[] args) throws Exception{

        Connection connection = null;

        Dentista dentista = new Dentista("Silva", "Maria", "666");

        try{
            connection = Conexao.getConnection();

            Statement statement = connection.createStatement();
            statement.execute(sqlCreate);

            PreparedStatement preparedStatementInsert = connection.prepareStatement(sqlInsert);
            preparedStatementInsert.setString(1, dentista.getSobrenome());
            preparedStatementInsert.setString(2, dentista.getNome());
            preparedStatementInsert.setString(3, dentista.getMatricula());
            preparedStatementInsert.execute();

            connection.setAutoCommit(false); // Desativando para realizar o UPDATE

            PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
            preparedStatementUpdate.setString(1, dentista.setMatricula("777"));
            preparedStatementUpdate.setString(2, dentista.getSobrenome());
            preparedStatementUpdate.execute();

            connection.setAutoCommit(true); // Voltando o autocommit para true

            ResultSet rs = statement.executeQuery(sqlSelect);

            while(rs.next()){
                System.out.println(rs.getInt(1) + ": " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            connection.rollback();
        } finally {
            connection.close();
        }
    }

}
