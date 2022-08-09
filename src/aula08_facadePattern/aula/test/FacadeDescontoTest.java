package aula08_facadePattern.aula.test;

import aula08_facadePattern.aula.service.impl.FacadeDesconto;
import aula08_facadePattern.aula.model.Cartao;
import aula08_facadePattern.aula.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacadeDescontoTest {

    private FacadeDesconto fd = new FacadeDesconto();
    private Cartao c;
    private Produto p;

    @BeforeEach
    void doBefore(){
        c = new Cartao("123456789100", "Star Bank");
        p = new Produto("ervilhas", "latas");
    }

    @Test
    void validarDescontoBanco(){
        p.setTipo("frescas");

        int desconto = fd.desconto(c, p, 1);
        assertEquals(20, desconto);
    }

    @Test
    void validarDescontoProduto(){
        c.setBanco("Nubank");

        int desconto = fd.desconto(c, p, 1);
        assertEquals(10, desconto);
    }

    @Test
    void validarDescontoQuantidade(){
        p.setTipo("frescas");
        c.setBanco("Nubank");

        int desconto = fd.desconto(c, p, 14);
        assertEquals(15, desconto);
    }

    @Test
    void validarTodosDescontos(){
        int desconto = fd.desconto(c, p, 14);
        assertEquals(45, desconto);
    }
}
