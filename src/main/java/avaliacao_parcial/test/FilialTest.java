package avaliacao_parcial.test;

import avaliacao_parcial.model.Filial;
import avaliacao_parcial.dao.config.ConfiguracaoJDBC;
import avaliacao_parcial.dao.impl.FilialDaoH2;
import avaliacao_parcial.service.FilialService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilialTest {

    static final Logger log = Logger.getLogger(FilialTest.class);

    private FilialService filialService = new FilialService(new FilialDaoH2(new ConfiguracaoJDBC()));

    @BeforeAll
    static void configLog(){
        BasicConfigurator.configure();
    }

    @Test
    void criando5filiais(){

        log.info("Teste de crição de 5 filiais");

        Filial filial1 = filialService.salvar(new Filial("Hotel Bonito", "Feliz", 123, "Bonito", "MS", true));
        log.info("Filial " + filial1.getNome() + " cadastrada com id " + filial1.getId());

        Filial filial2 = filialService.salvar(new Filial("Hotel Foz", "Tigre", 12, "Foz do Iguaçu", "PR", true));
        log.info("Filial " + filial2.getNome() + " cadastrada com id " + filial2.getId());

        Filial filial3 = filialService.salvar(new Filial("Hotel Curitiba", "Vicente", 3212, "Curitiba", "PR", false));
        log.info("Filial " + filial3.getNome() + " cadastrada com id " + filial3.getId());


        Filial filial4 = filialService.salvar(new Filial("Hotel Santa Maria", "Bagre", 123, "Santa Maria", "RS", false));
        log.info("Filial " + filial4.getNome() + " cadastrada com id " + filial4.getId());

        Filial filial5 = filialService.salvar(new Filial("Hotel POA", "Tranquila", 12356, "Porto Alegre", "rS", true));
        log.info("Filial " + filial5.getNome() + " cadastrada com id " + filial5.getId());
    }
}
