package aula15.service;

import aula15.dao.IDao;
import aula15.model.Paciente;

import java.sql.SQLException;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente paciente) throws SQLException {
        return pacienteIDao.salvar(paciente);
    }

    public Paciente buscar(Integer id) throws SQLException{
        return pacienteIDao.buscar(id);
    }

}
