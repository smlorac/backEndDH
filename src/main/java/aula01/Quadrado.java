package aula01;

public class Quadrado extends Figura{

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    double calcularPerimetro() {
        return 4 * this.lado;
    }
}
