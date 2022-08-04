package aula04_chainOfRespons;

public class GerenciadorComercial extends Gerenciador{
    @Override
    public void verificar(Mail m) {
        if (m.getDestino().equalsIgnoreCase("comercial@colmeia.com") || m.getAssunto().equalsIgnoreCase("Comercial")){
            System.out.println("Enviando para o time Comercial");
        } else {
            if(this.getSeguinte() != null){
                this.getSeguinte().verificar(m);
            }
        }
    }
}
