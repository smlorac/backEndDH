package aula04_chainOfRespons.mesa;

public class ManagerEmbalagem extends Manager{
    @Override
    public void verificar(Artigo a) {
        if (a.getEmbalagem().equalsIgnoreCase("saud?vel") || a.getEmbalagem().equalsIgnoreCase("quase saud?vel")){
            System.out.println("Teste de embalagem ok");
            System.out.println("ACEITO!");
        } else {
            System.out.println("REJEITADO!");
        }
    }
}
