package aula05_proxyPattern.aulaSinc;

import java.time.LocalDate;

public class ServicoVacinar implements Vacinar{
    @Override
    public void vacinarPessoa(String rg, LocalDate dataVacina, String nomeVacina) {
        System.out.println("RG " + rg + " vacinado(a) em " + dataVacina + " com " + nomeVacina);
    }
}
