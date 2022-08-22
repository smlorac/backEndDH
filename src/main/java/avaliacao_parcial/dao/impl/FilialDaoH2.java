package avaliacao_parcial.dao.impl;

import avaliacao_parcial.dao.IDao;
import avaliacao_parcial.model.Filial;
import avaliacao_parcial.dao.config.ConfiguracaoJDBC;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FilialDaoH2 implements IDao<Filial> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = Logger.getLogger(FilialDaoH2.class);

    public FilialDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Filial salvar(Filial filial) {
        log.info("Cadastrando nova filial: " + filial.toString());

        Connection connection = configuracaoJDBC.conectar();

        Statement st = null;

        String query = String.format("INSERT INTO filial (nome, rua, numero, cidade, estado, eh5estrelas) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", filial.getNome(), filial.getRua(), filial.getNumero(), filial.getCidade(), filial.getEstado(), filial.isEh5estrelas());

        try {
            st = connection.createStatement();
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet keys = st.getGeneratedKeys();

            if (keys.next()){
                filial.setId(keys.getInt(1));
            }
            st.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return filial;
    }
}
