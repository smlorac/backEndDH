package aula08_facadePattern.aula;

import aula08_facadePattern.aula.model.Cartao;
import aula08_facadePattern.aula.model.Produto;
import aula08_facadePattern.aula.service.impl.FacadeDesconto;

public class Main {
    public static void main(String[] args) {
        FacadeDesconto fd = new FacadeDesconto();

        Cartao c = new Cartao("123456789101", "Star Bank");
        Produto p = new Produto("ervilhas", "latas");

        System.out.println("Desconto: " + fd.desconto(c, p, 20));
    }
}
