package aula01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiguraTest {

    @Test
    void testeCirculo(){
        Circulo c = new Circulo(2);
        Assertions.assertEquals(2 * Math.PI * 2, c.calcularPerimetro());
    }

    @Test
    void testeQuadrado(){
        Quadrado q = new Quadrado(2);
        Assertions.assertEquals(4 * 2, q.calcularPerimetro());
    }
}
