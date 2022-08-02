package aula03;

public class Afiliado extends Vendedor{

    private int quantidadedeVendas;

    public Afiliado(String nome) {
        super(nome);
    }

    public int getQuantidadeVendas() {
        return quantidadedeVendas;
    }

    public void vender(int quantidadeVendas) {
        this.quantidadedeVendas = quantidadeVendas;
    }

    @Override
    public int calcularPontos() {
        return getQuantidadeVendas() * 15;
    }

    @Override
    public void recategorizar(int pontos) {
        if (calcularPontos() >= 20 && calcularPontos() <= 30){
            setCategoria("aprendiz");
        } else if (calcularPontos() > 30 && calcularPontos() <= 40){
            setCategoria("bom");
        } else if (calcularPontos() > 40){
            setCategoria("mestre");
        }
    }

    @Override
    public void exibirVendedor() {
        System.out.println("Nome: " + getNome() + "\nCategoria: " + getCategoria() + "\nTotal de pontos: " + calcularPontos());
    }
}
