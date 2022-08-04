package aula05_proxyPattern.aulaSinc;

import java.time.LocalDate;

public class ServicoVacinarProxy implements Vacinar{
    @Override
    public void vacinarPessoa(String rg, LocalDate dataVacina, String nomeVacina) {
        if (dataVacina.isBefore(LocalDate.now())){
            ServicoVacinar servicoVacinar = new ServicoVacinar();
            servicoVacinar.vacinarPessoa(rg, dataVacina, nomeVacina);
            System.out.println("Pessoa vacinada com sucesso.");
        } else {
            System.out.println("A data de aplicação não é viável.");
        }
    }
}
