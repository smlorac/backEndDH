package aula18_maven.mesa.service;

import aula18_maven.mesa.dao.IDao;
import aula18_maven.mesa.dao.impl.PacienteDaoH2;
import aula18_maven.mesa.model.Paciente;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(PacienteDaoH2 pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente paciente){
        return pacienteIDao.salvar(paciente);
    }

    public Paciente buscar(Integer id){
        return pacienteIDao.buscar(id);
    }

    public void deletar(Integer id){
        pacienteIDao.deletar(id);
    }
}
