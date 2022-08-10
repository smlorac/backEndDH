package aula09.mesa;

import org.junit.jupiter.api.Test;

import static aula09.mesa.Roupa.getI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoupaFactoryTest {

    @Test
    void criandoRoupa(){

        RoupaFlyFactory rf = new RoupaFlyFactory();

        Roupa camisa = rf.obterRoupa("xs", "camisa", true, true);
        Roupa calca = rf.obterRoupa("xs", "calça", true, true);

        assertEquals(camisa.getTamanho(), "xs");
        assertEquals(calca.iseNovo(), true);
    }

    @Test
    void tamanhoListas(){

        RoupaFlyFactory rf = new RoupaFlyFactory();

        Roupa camisa = rf.obterRoupa("xs", "camisa", true, true);
        Roupa calca = rf.obterRoupa("xs", "calça", true, true);

        assertEquals(RoupaFlyFactory.listaTamanhoXS.size(), 1);
        assertEquals(getI(), 2);
    }
}
