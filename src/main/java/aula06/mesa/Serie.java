package aula06.mesa;

public class Serie implements ISerie{
    @Override
    public String getSerie(String nome) {
        return "www." + nome;
    }
}
