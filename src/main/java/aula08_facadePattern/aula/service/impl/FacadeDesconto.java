package aula08_facadePattern.aula.service.impl;

import aula08_facadePattern.aula.model.Cartao;
import aula08_facadePattern.aula.model.Produto;
import aula08_facadePattern.aula.service.IFacadeDesconto;

public class FacadeDesconto implements IFacadeDesconto {

    //armazenando uma instancia de cada API
    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;

    //criando as instancias
    public FacadeDesconto() {
        apiCartao = new ApiCartao();
        apiProduto = new ApiProduto();
        apiQuantidade = new ApiQuantidade();
    }

    //simplificando os descontos
    @Override
    public int desconto(Cartao cartao, Produto produto, int quantidade) {
        int desconto = 0;
        desconto += apiQuantidade.desconto(quantidade);
        desconto += apiProduto.desconto(produto);
        desconto += apiCartao.desconto(cartao);

        return desconto;
    }
}
