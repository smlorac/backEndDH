package aula04_chainOfRespons;

public class GerenciadorTecnico extends Gerenciador{
    @Override
    public void verificar(Mail m) {
        if (m.getDestino().equalsIgnoreCase("tecnico@colmeia.com") || m.getAssunto().equalsIgnoreCase("Técnica")){
            System.out.println("Enviando para o time Técnico");
        } else {
            if(this.getSeguinte() != null){
                this.getSeguinte().verificar(m);
            }
        }
    }
}
