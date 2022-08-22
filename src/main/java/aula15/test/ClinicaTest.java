package aula15.test;

import aula14_padraoDAO.aula.dao.ConfiguracaoJDBC;
import aula15.dao.impl.EnderecoDaoH2;
import aula15.dao.impl.PacienteDaoH2;
import aula15.model.Endereco;
import aula15.model.Paciente;
import aula15.service.EnderecoService;
import aula15.service.PacienteService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Date;

public class ClinicaTest {

    private static final Logger log = Logger.getLogger(ClinicaTest.class);

    private EnderecoService enderecoService = new EnderecoService(new EnderecoDaoH2(new ConfiguracaoJDBC()));
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new ConfiguracaoJDBC()));

    @BeforeAll
    static void configLog(){
        BasicConfigurator.configure();
    }

    @Test
    void clinicasTest() throws SQLException {

        Endereco endereco = enderecoService.salvar(new Endereco("Piapara", 666, "Foz", "Vila"));

        Date data = new Date(2022, 03, 01);

        Paciente paciente = pacienteService.salvar(new Paciente("Carol", "Silva", "66666", data, 1));
    }
}
