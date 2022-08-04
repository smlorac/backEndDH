package aula04_chainOfRespons;

public class ProcessaMail {
    public static void main(String[] args) {

        CheckMail cm = new CheckMail();

        cm.verificar(new Mail("caroline@email.com", "tecnica@digitalhouse.com", "Reclamação"));
        cm.verificar(new Mail("caroline@email.com", "tecnico@colmeia.com", "Reclamação"));
        cm.verificar(new Mail("caroline@email.com", "colmeia@colmeia.com", "Gerência"));
    }
}
