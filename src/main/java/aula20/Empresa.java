package aula20;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {

    private String nome;
    private String razaoSocial;
    List<Funcionario> funcionarios = new ArrayList<>();

    public Empresa(String nome, String razaoSocial) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
    }

    public void adicionarFuncionario(Funcionario f){
        funcionarios.add(f);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
