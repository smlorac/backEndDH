package aula05_proxyPattern.aulaSinc;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaTest {

    @Test
    public void testVacinarOk(){
        Pessoa p1 = new Pessoa("Carol", "Silva", "12345678", LocalDate.of(2022, 01, 01), "Astrazeneca");
        Vacinar vacinar = new ServicoVacinarProxy();

        vacinar.vacinarPessoa(p1.getRg(), p1.getDataVacina(), p1.getNomeVacina());
        System.out.println(p1);
    }

    @Test
    public void testVacinarFail(){
        Pessoa p1 = new Pessoa("Nico", "Lima", "12345687", LocalDate.of(2022, 12,12), "Pfizer");
        Vacinar vacinar = new ServicoVacinarProxy();

        vacinar.vacinarPessoa(p1.getRg(), p1.getDataVacina(), p1.getNomeVacina());
        System.out.println(p1);
    }
}
