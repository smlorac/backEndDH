package aula01;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;
    private String sobrenome;
    LocalDate dataNascimento;
    List<String> listaNomes = new ArrayList<>();
    //List nâo pode ser instanciado pois é uma interface, poderia ter feito com ArrayList

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<String> getListaNomes() {
        return listaNomes;
    }

    public int calcularIdade(){
        int idade = Period.between(getDataNascimento(), LocalDate.now()).getYears();
        return idade;
    }

    public List<String> adicionarPessoas(Pessoa p){
        int tamanhoNome = p.getNome().length();
        int idade = p.calcularIdade();

        if (tamanhoNome >= 5 && idade >= 18){
            listaNomes.add(p.getNome());
            System.out.println(listaNomes);
        }

        return listaNomes;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
