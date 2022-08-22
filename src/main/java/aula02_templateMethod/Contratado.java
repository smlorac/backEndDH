package aula02_templateMethod;

public class Contratado extends Funcionario{

    private double valorHora;
    private int horas;

    public Contratado(String nome, String sobrenome, String numeroConta, double valorHora, int horas) {
        super(nome, sobrenome, numeroConta);
        this.valorHora = valorHora;
        this.horas = horas;
    }


    @Override
    public double calcularSaldo() {
        return this.valorHora * this.horas;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("\nRecibo de contratado: " + quantia);
    }

    @Override
    public void depositar(double quantia) {
        System.out.println("Foi depositado " + quantia);
    }
}
