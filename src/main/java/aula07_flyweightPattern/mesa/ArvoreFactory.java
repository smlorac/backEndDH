package aula07_flyweightPattern.mesa;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static Map<String, Arvore> arvoreFly = new HashMap<>();

    public Arvore floresta(String tipo){

        if (!arvoreFly.containsKey(tipo)){
            arvoreFly.put(tipo, new Arvore(tipo));
            //System.out.println("nova árvore");
            return arvoreFly.get(tipo);
        }
        //System.out.println("árvore já criada");
        return arvoreFly.get(tipo);
    }

}
