package aula03;

public abstract class Vendedor {

    //poderia ter utilizado protected
    private String nome;
    private int pontos;
    private String categoria;

    public Vendedor(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.categoria = "novato";
    }

    public void mostrarCategoria(){
        pontos = calcularPontos();
        recategorizar(pontos);
        exibirVendedor();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public abstract int calcularPontos();

    public abstract void recategorizar(int pontos);

    public abstract void exibirVendedor();
}
