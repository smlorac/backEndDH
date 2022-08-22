package aula14_padraoDAO.aula.test;

import aula14_padraoDAO.aula.dao.ConfiguracaoJDBC;
import aula14_padraoDAO.aula.dao.impl.MedicamentoDAOH2;
import aula14_padraoDAO.aula.model.Medicamento;
import aula14_padraoDAO.aula.service.MedicamentoService;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedicamentoTest {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDAOH2(new ConfiguracaoJDBC()));

    @Test
    public void salvarMedicamentoTest(){
        BasicConfigurator.configure();

        Medicamento medicamento = new Medicamento("Novalgina", "Aiche", 10, 5.25);
        medicamentoService.salvar(medicamento);

        assertTrue(medicamento.getId() != null);

        Medicamento medicamento1 = new Medicamento("Dorflex","SanofiLascou",550,26.5);
        medicamentoService.salvar(medicamento1);
        assertTrue(medicamento1.getId()!=null);
    }
}
