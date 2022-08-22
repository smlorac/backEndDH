package aula18_maven.test.mesa;

import aula18_maven.mesa.dao.config.ConfiguracaoJDBC;
import aula18_maven.mesa.dao.impl.DentistaDaoH2;
import aula18_maven.mesa.dao.impl.EnderecoDaoH2;
import aula18_maven.mesa.dao.impl.PacienteDaoH2;
import aula18_maven.mesa.service.DentistaService;
import aula18_maven.mesa.service.EnderecoService;
import aula18_maven.mesa.service.PacienteService;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClinicaTest {


    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new ConfiguracaoJDBC()));

    private EnderecoService enderecoService = new EnderecoService(new EnderecoDaoH2(new ConfiguracaoJDBC()));

    private DentistaService dentistaService = new DentistaService(new DentistaDaoH2(new ConfiguracaoJDBC()));

    @Test
    public void salvarMedicamentoTest(){
        BasicConfigurator.configure();

    }
}
