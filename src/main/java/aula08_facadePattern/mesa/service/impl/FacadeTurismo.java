package aula08_facadePattern.mesa.service.impl;

import aula08_facadePattern.mesa.model.Viagem;
import aula08_facadePattern.mesa.service.IFacadeTurismo;

public class FacadeTurismo implements IFacadeTurismo {

    private ApiVoo apiVoo;
    private ApiHotel apiHotel;

    public FacadeTurismo() {
        apiVoo = new ApiVoo();
        apiHotel = new ApiHotel();
    }

    @Override
    public Viagem buscar(Viagem viagem) {
        viagem.setCompanhia(apiVoo.buscarVoo(viagem.getDataPartida(), viagem.getDataRetorno(), viagem.getOrigem(), viagem.getDestino()));
        viagem.setHotel(apiHotel.buscarHotel(viagem.getDataPartida(), viagem.getDataRetorno(), viagem.getDestino()));
        return viagem;
    }
}
