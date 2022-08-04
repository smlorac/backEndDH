package aula04_chainOfRespons.mesa;

public abstract class Manager {

    protected Manager managerSeguinte;

    public Manager getSeguinte() {
        return managerSeguinte;
    }

    public void setSeguinte(Manager managerSeguinte) {
        this.managerSeguinte = managerSeguinte;
    }

    public abstract void verificar(Artigo a);
}
