package aula06.mesa;

public class SerieProxy implements ISerie{

    private int qtdViews;
    private Serie serie;

    public SerieProxy(Serie serie) {
        this.qtdViews = 0;
        this.serie = new Serie();
    }

    public void setQtdViews(int qtdViews) {
        this.qtdViews = qtdViews;
    }

    @Override
    public String getSerie(String nome) {
        if (qtdViews <= 5){
            return this.serie.getSerie(nome);
        } else {
            throw new SerieNaoHabilitadaException("Excede o número de reproduções permitidas");
        }
    }
}
