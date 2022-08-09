package aula08_facadePattern.aula.service;

import aula08_facadePattern.aula.model.Cartao;
import aula08_facadePattern.aula.model.Produto;

public interface IFacadeDesconto {

    int desconto(Cartao cartao, Produto produto, int quantidade);
}
