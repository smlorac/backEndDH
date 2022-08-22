package aula13_consultasETransacoes.mesa;

public class Dentista {

    private int id;
    private String sobrenome;
    private String nome;
    private String matricula;

    public Dentista(String sobrenome, String nome, String matricula) {
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String setMatricula(String matricula) {
        this.matricula = matricula;
        return matricula;
    }
}
