package aula02_templateMethod;

import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    @Test
    void calculos(){
        Funcionario f1 = new Efetivo("Caroline", "Machado", "123", 4500, 600, 150.25);
        Funcionario f2 = new Contratado("Nicolas", "Lima", "666", 50, 60);

        f1.pagamentoSalario();
        f2.pagamentoSalario();
    }
}
