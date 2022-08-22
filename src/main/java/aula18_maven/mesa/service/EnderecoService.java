package aula18_maven.mesa.service;

import aula18_maven.mesa.dao.IDao;
import aula18_maven.mesa.model.Endereco;

public class EnderecoService {

    private IDao<Endereco> enderecoIDao;

    public EnderecoService(IDao<Endereco> enderecoIDao) {
        this.enderecoIDao = enderecoIDao;
    }

    public Endereco salvar(Endereco endereco){
        return enderecoIDao.salvar(endereco);
    }

    public Endereco buscar(Integer id){
        return enderecoIDao.buscar(id);
    }

    public void deletar(Integer id){
        enderecoIDao.deletar(id);
    }
}
