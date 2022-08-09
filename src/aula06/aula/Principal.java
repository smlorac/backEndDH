package aula06.aula;

public class Principal {
    public static void main(String[] args) {

        GradeDeFilmesProxy proxy = new GradeDeFilmesProxy(new GradeDeFilmes());

        proxy.setIp(new Ip(20, 23, 25, 24));

        try{
            System.out.println(proxy.getfilme("Superbad").getLink());
            System.out.println("Acesso do filme liberado");
        } catch (FilmeNaoHabilitadoException e){
            System.out.println(e.getMessage());
        }
    }
}
