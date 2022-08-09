package aula08_facadePattern.mesa.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ApiHotel {

    public String buscarHotel(LocalDate dataPartida, LocalDate dataRetorno, String destino){
        List<String> hoteis = Arrays.asList("Ibis", "Transamerica", "Hilton");
        Random r = new Random();
        return hoteis.get(r.nextInt(hoteis.size()));
    }
}
