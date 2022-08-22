package aula11_acessoBancoDados.aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Animal;CREATE TABLE Animal"+
    "("+"id INT PRIMARY KEY AUTO_INCREMENT,"
    +"Nome VARCHAR(100) NOT NULL,"
    +"Tipo VARCHAR(100) NOT NULL" + ")";

    private static final String sqlInsert1 = "INSERT INTO Animal(Nome, Tipo) VALUES ('Ziva', 'cachorro')";
    private static final String sqlInsert2 = "INSERT INTO Animal(Nome, Tipo) VALUES ('Bubba', 'cachorro')";
    private static final String sqlInsert3 = "INSERT INTO Animal(Nome, Tipo) VALUES ('Sasha', 'gato')";
    private static final String sqlInsert4 = "INSERT INTO Animal(Nome, Tipo) VALUES ('Nagini', 'cobra')";
    private static final String sqlInsert5 = "INSERT INTO Animal(Nome, Tipo) VALUES ('Hedwiges', 'coruja')";

    private static final String sqlSelect = "SELECT * FROM Animal";

    private static final String sqlDelete = "DELETE FROM Animal WHERE id=5";

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:~/animal", "sa", "");

        try{
            Statement statement = connection.createStatement();

            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);

            statement.execute(sqlDelete);

            ResultSet resultSet = statement.executeQuery(sqlSelect);

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + ", " + resultSet.getString(3));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (connection == null){
                return;
            }
            connection.close();
        }
    }
}
