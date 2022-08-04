package aula04_chainOfRespons.mesa;

public class ManagerLote extends Manager{
    @Override
    public void verificar(Artigo a) {
        if (a.getLote() > 1000 && a.getLote() < 2000){
            System.out.println("Teste de lote ok");
            this.getSeguinte().verificar(a);
        } else {
            if (this.getSeguinte() != null){
                System.out.println("REJEITADO!");
            }
        }
    }
}
