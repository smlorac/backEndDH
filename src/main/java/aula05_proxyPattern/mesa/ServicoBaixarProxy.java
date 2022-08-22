package aula05_proxyPattern.mesa;

public class ServicoBaixarProxy implements Baixar{
    @Override
    public void baixarMusica(String id, String tipo) {
        if (tipo.equalsIgnoreCase("premium")){
            ServicoBaixar servicoBaixar = new ServicoBaixar();
            servicoBaixar.baixarMusica(id, tipo);
            System.out.println("Música baixada");
        } else if (tipo.equalsIgnoreCase("free")) {
            System.out.println("Você não pode baixar músicas. Se quiser virar Premium, fale com a gente!");
        }
    }
}
