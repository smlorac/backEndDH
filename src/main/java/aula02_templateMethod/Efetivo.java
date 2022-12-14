package aula02_templateMethod;

public class Efetivo extends Funcionario{

    private double salarioBase;
    private double descontos;
    private double bonificacoes;

    public Efetivo(String nome, String sobrenome, String numeroConta, double salarioBase, double descontos, double bonificacoes) {
        super(nome, sobrenome, numeroConta);
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.bonificacoes = bonificacoes;
    }

    @Override
    public double calcularSaldo() {
        return this.salarioBase + this.bonificacoes - this.descontos;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("\nRecibo de Efetivo: " + quantia);
    }

    @Override
    public void depositar(double quantia) {
        System.out.println("Foi depositado " + quantia);
    }

}
