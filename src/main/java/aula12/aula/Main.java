package aula12.aula;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Usuario;CREATE TABLE Usuario"
            +"("
            +"id INT PRIMARY KEY AUTO_INCREMENT,"
            +"Primeiro_Nome VARCHAR(100) NOT NULL,"
            +"Sobrenome VARCHAR(500) NOT NULL,"
            +"Idade INT NOT NULL"
            + ")";

    private static final String sqlInsert1 = "INSERT INTO Usuario(Primeiro_Nome, Sobrenome, Idade) VALUES ('Carol', 'M. da Silva', 29)";
    private static final String sqlInsert2 = "INSERT INTO Usuario(Primeiro_Nome, Sobrenome, Idade) VALUES ('Nico', 'B. Lima', 24)";
    private static final String sqlInsert3 = "INSERT INTO Usuario(Primeiro_Nome, Sobrenome, Idade) VALUES ('Nome', 'Sobrenome', 25)";

    private static final String sqlDelete = "DELETE FROM Usuario WHERE id=3";

    private static final Logger logger = Logger.getLogger(aula10_logger.aula.Main.class);

    public static void main(String[] args) throws Exception{
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        Connection connection = null;

        BasicConfigurator.configure();

        try {

            connection = DriverManager.getConnection("jdbc:h2:~/usuario", "sa", "");

            Statement statement = connection.createStatement();

            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);

            statement.execute(sqlDelete);

            logger.info("O usuário 3 foi excluído");

        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if (connection == null){
                return;
            }
            connection.close();
        }
    }
}
