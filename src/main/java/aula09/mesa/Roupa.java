package aula09.mesa;

public class Roupa {

    private String tamanho;
    private String tipo;
    private boolean eNovo;
    private boolean importada;

    private static int i = 0;

    public Roupa(String tamanho, String tipo, boolean eNovo, boolean importada) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.eNovo = eNovo;
        this.importada = importada;
        i++;
    }

    public static int getI() {
        return i;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean iseNovo() {
        return eNovo;
    }

    public boolean isImportada() {
        return importada;
    }
}
