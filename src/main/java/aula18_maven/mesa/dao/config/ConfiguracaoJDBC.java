package aula18_maven.mesa.dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC {

    private String jdbcDriver;
    private String url;
    private String usuario;
    private String senha;

    public ConfiguracaoJDBC(String jdbcDriver, String url, String usuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.url = "jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'createAula18.sql'";
        this.usuario = "sa";
        this.senha = "";
    }

    public Connection conectar(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
