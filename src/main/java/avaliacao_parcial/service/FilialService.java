package avaliacao_parcial.service;

import avaliacao_parcial.dao.IDao;
import avaliacao_parcial.model.Filial;

public class FilialService {

    private IDao<Filial> filialIDao;

    public FilialService(IDao<Filial> filialIDao) {
        this.filialIDao = filialIDao;
    }

    public Filial salvar(Filial filial){
        return filialIDao.salvar(filial);
    }
}
