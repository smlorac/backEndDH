package aula07_flyweightPattern.mesa;

public class Arvore {

    private int altura;
    private int largura;
    private String cor;
    private static String tipo;

    public Arvore(String tipo) {
        this.tipo = tipo;

        if (tipo.equalsIgnoreCase("ornamentais")){
            this.altura = 200;
            this.largura = 400;
            this.cor = "verde";
        } else if (tipo.equalsIgnoreCase("frutíferas")){
            this.altura = 500;
            this.largura = 300;
            this.cor = "vermelho";
        } else if (tipo.equalsIgnoreCase("floríferas")){
            this.altura = 100;
            this.largura = 200;
            this.cor = "azul";
        }
    }

    @Override
    public String toString() {
        return "Arvore{" +
                "altura=" + altura +
                ", largura=" + largura +
                ", cor='" + cor + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
