package aula04_chainOfRespons.mesa;

public class CheckQuality {

    Manager inicial;

    public CheckQuality(){
        this.inicial = new ManagerLote();
        Manager peso = new ManagerPeso();
        Manager embalagem = new ManagerEmbalagem();

        inicial.setSeguinte(peso);
        peso.setSeguinte(embalagem);
    }

    public void verificar(Artigo a){
        inicial.verificar(a);
    }
}
