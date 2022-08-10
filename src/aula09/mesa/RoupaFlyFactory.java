package aula09.mesa;

import java.util.HashMap;

public class RoupaFlyFactory {

    public static final HashMap<String, Roupa> listaTamanhoXS = new HashMap<>();
    public static final HashMap<String, Roupa> listaTamanhoS = new HashMap<>();
    public static final HashMap<String, Roupa> listaTamanhoM = new HashMap<>();
    public static final HashMap<Boolean, Roupa> listaImportadas = new HashMap<>();
    public static final HashMap<Boolean, Roupa> listaMasCondicoes = new HashMap<>();

    public Roupa obterRoupa(String tamanho, String tipo, boolean eNovo, boolean importada){
        Roupa roupa = null;

        if (roupa == null){
            roupa = new Roupa(tamanho, tipo, eNovo, importada);

            if (roupa.getTamanho().equalsIgnoreCase("xs")){
                listaTamanhoXS.put(tamanho, roupa);
            } else if (roupa.getTamanho().equalsIgnoreCase("s")){
                listaTamanhoS.put(tamanho, roupa);
            } else if (roupa.getTamanho().equalsIgnoreCase("m")){
                listaTamanhoM.put(tamanho, roupa);
            } else if (roupa.isImportada()){
                listaImportadas.put(importada, roupa);
            } else if (!roupa.iseNovo()){
                listaMasCondicoes.put(eNovo, roupa);
            }
        }
        return roupa;
    }

}
