package aula15.service;

import aula15.dao.IDao;
import aula15.model.Endereco;

import java.sql.SQLException;

public class EnderecoService {

    private IDao<Endereco> enderecoIDao;

    public EnderecoService(IDao<Endereco> enderecoIDao) {
        this.enderecoIDao = enderecoIDao;
    }

    public Endereco salvar(Endereco endereco) throws SQLException{
        return enderecoIDao.salvar(endereco);
    }
}
