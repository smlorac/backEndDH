package aula18_maven.mesa.service;

import aula18_maven.mesa.dao.IDao;
import aula18_maven.mesa.model.Dentista;

public class DentistaService {

    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    public Dentista salvar(Dentista dentista){
        return dentistaIDao.salvar(dentista);
    }

    public Dentista buscar(Integer id){
        return dentistaIDao.buscar(id);
    }

    public void deletar(Integer id){
        dentistaIDao.deletar(id);
    }
}
