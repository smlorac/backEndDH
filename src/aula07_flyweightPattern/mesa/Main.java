package aula07_flyweightPattern.mesa;

public class Main {
    public static void main(String[] args) {

        ArvoreFactory af = new ArvoreFactory();

        for (int i = 1; i <= 500000; i++){
            Arvore vermelha = af.floresta("frutíferas");
            System.out.println(vermelha);
            Arvore verde = af.floresta("ornamentais");
            System.out.println(verde);
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
