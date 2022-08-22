package aula05_proxyPattern.mesa;

public class ServicoBaixar implements Baixar{
    @Override
    public void baixarMusica(String id, String tipo) {
        System.out.println("Usuário " + id + " (" + tipo + ")");
    }
}
