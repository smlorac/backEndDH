package aula04_chainOfRespons;

public class GerenciadorSpam extends Gerenciador{
    @Override
    public void verificar(Mail m) {
        System.out.println("Marcado como spam");
    }
}
