package aula11_acessoBancoDados.mesa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Figura;CREATE TABLE Figura"+
            "("+"id INT PRIMARY KEY AUTO_INCREMENT,"
            +"Tipo VARCHAR(100) NOT NULL,"
            +"Cor VARCHAR(100) NOT NULL" + ")";

    private static final String sqlInsert1 = "INSERT INTO Figura(Tipo, Cor) VALUES ('circulo', 'vermelho')";
    private static final String sqlInsert2 = "INSERT INTO Figura(Tipo, Cor) VALUES ('circulo', 'azul')";
    private static final String sqlInsert3 = "INSERT INTO Figura(Tipo, Cor) VALUES ('quadrado', 'vermelho')";
    private static final String sqlInsert4 = "INSERT INTO Figura(Tipo, Cor) VALUES ('quadrado', 'azul')";
    private static final String sqlInsert5 = "INSERT INTO Figura(Tipo, Cor) VALUES ('quadrado', 'verde')";

    private static final String sqlSelect = "SELECT * FROM Figura";

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:~/figura", "sa", "");

        try{
            Statement statement = connection.createStatement();

            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);

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
