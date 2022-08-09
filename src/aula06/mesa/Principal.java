package aula06.mesa;

public class Principal {
    public static void main(String[] args) {

        try {
            Serie serie = new Serie();
            SerieProxy teste = new SerieProxy(serie);
            //teste 1 com 0
            System.out.println(teste.getSerie("carolinda"));

            Serie serie2 = new Serie();
            SerieProxy teste2 = new SerieProxy(serie2);
            teste2.setQtdViews(2);

            //teste 2 com 2
            System.out.println(teste2.getSerie("teste"));

            //teste 1 com 10 views
            teste.setQtdViews(10);
            teste.getSerie("carolinda");


        } catch (SerieNaoHabilitadaException e){
            System.out.println(e.getMessage());
        }
    }
}
