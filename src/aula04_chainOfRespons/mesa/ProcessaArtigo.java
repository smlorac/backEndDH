package aula04_chainOfRespons.mesa;

public class ProcessaArtigo {
    public static void main(String[] args) {

        CheckQuality cq = new CheckQuality();

        cq.verificar(new Artigo("cenoura",800, 1500, "saudavel")); //rejeitado no lote
        cq.verificar(new Artigo("abacate", 1100, 1000, "saudavel")); //rejeitado no peso
        cq.verificar(new Artigo("banana", 1100, 1250, "estragado")); //rejeitado na embalagem
        cq.verificar(new Artigo("morango", 1100, 1250, "saud?vel")); //aceito
    }
}
