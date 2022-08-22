package aula08_facadePattern.aula.model;

public class Cartao {

    private String numero;
    private String banco;

    public Cartao(String numero, String banco) {
        this.numero = numero;
        this.banco = banco;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
