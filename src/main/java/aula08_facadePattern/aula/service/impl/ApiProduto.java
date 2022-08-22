package aula08_facadePattern.aula.service.impl;

import aula08_facadePattern.aula.model.Produto;

public class ApiProduto {

    public int desconto(Produto produto){
        if (produto.getTipo().compareTo("latas") == 0){
            return 10;
        } else {
            return 0;
        }
    }
}
