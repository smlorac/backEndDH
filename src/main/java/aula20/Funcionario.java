package aula20;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private String nome;
    private String sobrenome;
    private String documento;
    private double salario;

    public Funcionario(String nome, String sobrenome, String documento, double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", salario=" + salario +
                '}';
    }
}
