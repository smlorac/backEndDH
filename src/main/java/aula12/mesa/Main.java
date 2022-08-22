package aula12.mesa;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Funcionario;CREATE TABLE Funcionario"
            + "("
            + "id INT PRIMARY KEY,"
            + "Nome_Completo VARCHAR(500) NOT NULL,"
            + "Email VARCHAR(200) NOT NULL,"
            + "Data_Nascimento DATE NOT NULL,"
            + "Cargo VARCHAR(100) NOT NULL"
            + ")";

    private static final String sqlInsert1 = "INSERT INTO Funcionario(id, Nome_Completo, Email, Data_Nascimento, Cargo) VALUES (1, 'Carol Machado', 'caroline@email.com', '1993-06-03', 'Líder')";
    private static final String sqlInsert2 = "INSERT INTO Funcionario(id, Nome_Completo, Email, Data_Nascimento, Cargo) VALUES (1, 'Patricia Suarez', 'patricia@email.com', '1999-03-06', 'Trainee')";
    private static final String sqlInsert3 = "INSERT INTO Funcionario(id, Nome_Completo, Email, Data_Nascimento, Cargo) VALUES (3, 'Nico Lima', 'nicolas@email.com', '1998-06-01', 'Líder')";

    private static final String sqlUpdate = "UPDATE Funcionario SET Nome_Completo='Nicolas Lima' WHERE id = 3";

    private static final String sqlDelete1 = "DELETE FROM Funcionario WHERE id=3";

    private static final String sqlDelete2 = "DELETE FROM Funcionario WHERE email='patricia@email.com'";

    private static final Logger logger = Logger.getLogger(aula10_logger.aula.Main.class);

    public static void main(String[] args) throws Exception {
        Connection connection = null;

        BasicConfigurator.configure();

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();

            statement.execute(sqlCreateTable);

            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
        } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e) {
            logger.error(e.getMessage());
        }
        try {
            connection = getConnection();

            Statement statement = connection.createStatement();

            statement.execute(sqlUpdate);
            logger.debug("Infos do funcionário 3 atualizadas");

            statement.execute(sqlDelete1);
            logger.info("Funcionario 3 excluido");

            statement.execute(sqlDelete2);
            logger.info("Funcionario 'patricia@email.com' excluido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection == null) {
                return;
            }
            connection.close();
        }
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/usuario", "sa", "");
    }
}

