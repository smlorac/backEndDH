package aula06.aula;

public class GradeDeFilmes implements IGradeDeFilmes{
    @Override
    public Filme getfilme(String nome) {
        Filme f = null;

        switch (nome){
            case "The White Tiger":
                f = new Filme(nome, "ARG", "www.whitetiger.com");
                break;
            case "His Houser":
                f = new Filme(nome, "BRA", "www.houser.com");
                break;
            case "Over The Moon":
                f = new Filme(nome, "COL", "www.overthemoon.com");
                break;
            case "Superbad":
                f = new Filme(nome, "ARG", "www.superbad.com");
                break;
            case "Útimo Filme":
                f = new Filme(nome, "BRA", "www.theend.com");
        }
        return f;
    }
}
