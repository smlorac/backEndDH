package aula09.aula;

import java.util.HashMap;

public class FlyweightTrianguloFactory {

    public static final HashMap<String, Triangulo> trianguloFlyweight = new HashMap<>();

    public static Triangulo obterTriangulo(String cor){
        Triangulo triangulo = trianguloFlyweight.get(cor);

        if (triangulo == null){
            triangulo = new Triangulo(cor);
            trianguloFlyweight.put(cor, triangulo);
        }
        return triangulo;
    }
}
