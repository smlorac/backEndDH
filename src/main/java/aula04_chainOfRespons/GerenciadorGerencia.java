package aula04_chainOfRespons;

public class GerenciadorGerencia extends Gerenciador{
    @Override
    public void verificar(Mail m) {
        if (m.getDestino().equalsIgnoreCase("gerencia@colmeia.com") || m.getAssunto().equalsIgnoreCase("Gerência")){
            System.out.println("Enviando para o time Gerência");
        } else {
            if(this.getSeguinte() != null){
                this.getSeguinte().verificar(m);
            }
        }
    }
}
