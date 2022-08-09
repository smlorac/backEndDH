package aula08_facadePattern.aula.service.impl;

import aula08_facadePattern.aula.model.Cartao;

public class ApiCartao {

    public int desconto(Cartao cartao){
        if (cartao.getBanco().compareTo("Star Bank") == 0){
            return 20;
        } else {
            return 0;
        }
    }

}
