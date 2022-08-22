package aula14_padraoDAO.aula.service;

import aula14_padraoDAO.aula.dao.IDAO;
import aula14_padraoDAO.aula.model.Medicamento;

public class MedicamentoService {

    private IDAO<Medicamento> medicamentoIDAO;

    public MedicamentoService(IDAO<Medicamento> medicamentoIDAO) {
        this.medicamentoIDAO = medicamentoIDAO;
    }

    public Medicamento salvar(Medicamento medicamento){
        return medicamentoIDAO.salvar(medicamento);
    }

    public Medicamento buscar(int id){
        return medicamentoIDAO.buscar(id);
    }
}
