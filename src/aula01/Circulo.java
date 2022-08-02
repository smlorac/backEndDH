package aula01;

public class Circulo extends Figura{

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    double calcularPerimetro() {
        return 2 * Math.PI * this.raio;
    }
}
