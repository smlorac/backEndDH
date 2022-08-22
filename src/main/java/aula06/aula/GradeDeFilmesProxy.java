package aula06.aula;

public class GradeDeFilmesProxy implements IGradeDeFilmes{

    private GradeDeFilmes gradeDeFilmes;
    private Ip ip;

    public GradeDeFilmesProxy(GradeDeFilmes gradeDeFilmes) {
        this.setFilme(gradeDeFilmes);
    }

    private void setFilme(GradeDeFilmes gradeDeFilmes) {
        this.gradeDeFilmes = gradeDeFilmes;
    }

    public void setIp(Ip ip){
        this.ip = ip;
    }

    @Override
    public Filme getfilme(String nome) throws FilmeNaoHabilitadoException{
        Filme f = gradeDeFilmes.getfilme(nome);

        if (!(getIp().getPais().equalsIgnoreCase(f.getPais()))){
            throw new FilmeNaoHabilitadoException("Filme não disponível no seu país");
        }
        return f;
    }

    private Ip getIp() {
        return ip;
    }
}
