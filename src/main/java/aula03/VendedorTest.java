package aula03;

import org.junit.jupiter.api.Test;

public class VendedorTest {

    @Test
    void testeVendedor(){

        Funcionario f1 = new Funcionario("Carol", 2);
        f1.obterAfiliados(2);
        f1.vender(3);

        f1.mostrarCategoria();

        Afiliado a1 = new Afiliado("Nicolas");
        a1.vender(1);

        a1.mostrarCategoria();
    }
}
