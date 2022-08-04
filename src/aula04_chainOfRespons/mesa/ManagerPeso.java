package aula04_chainOfRespons.mesa;

public class ManagerPeso extends Manager{
    @Override
    public void verificar(Artigo a) {
        if (a.getPeso() > 1200 && a.getPeso() < 1300){
            System.out.println("Teste de peso ok");
            this.getSeguinte().verificar(a);
        } else {
            if (this.getSeguinte() != null){
                System.out.println("REJEITADO!");
            }
        }
    }
}
