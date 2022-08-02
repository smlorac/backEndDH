package aula03;

public class Funcionario extends Vendedor{

    private int tempoDeCasa;
    private int quantidadeAfiliados;
    private int quantidadeVendas;

    public Funcionario(String nome, int tempoDeCasa) {
        super(nome);
        this.tempoDeCasa = tempoDeCasa;
    }

    public int getQuantidadeAfiliados() {
        return quantidadeAfiliados;
    }

    public void obterAfiliados(int quantidadeAfiliados) {
        this.quantidadeAfiliados = quantidadeAfiliados;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void vender(int quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }

    @Override
    public int calcularPontos() {
        return getQuantidadeAfiliados() * 10 + getQuantidadeVendas() * 5 + this.tempoDeCasa * 5;
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
