package aula06.aula;

public interface IGradeDeFilmes {

    Filme getfilme(String nome) throws FilmeNaoHabilitadoException;
}
