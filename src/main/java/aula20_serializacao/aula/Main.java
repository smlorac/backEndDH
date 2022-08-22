package aula20_serializacao.aula;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro ziva = new Cachorro(5, "Ziva");
        Cachorro bubba = new Cachorro(2, "Bubba");
        Cachorro zeus = new Cachorro(13, "Zeus");
        Cachorro guria = new Cachorro(9, "Guria");
        Cachorro venus = new Cachorro(9, "Venus");

        cachorros.add(ziva);
        cachorros.add(bubba);
        cachorros.add(zeus);
        cachorros.add(guria);
        cachorros.add(venus);

        //salvando a coleção em um arquivo
        FileOutputStream outArquivos = null;
        try {
            outArquivos = new FileOutputStream("saidaCachorros.txt");

            ObjectOutputStream outObjetos = new ObjectOutputStream(outArquivos);

            //escrevendo
            outObjetos.writeObject(cachorros);
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //recuperando a colecao com cada uma das páginas do arquivo
        List<Cachorro> cachorrosArquivo = null;

        FileInputStream inArquivos = null;
        try{
            inArquivos = new FileInputStream("saidaCachorros.txt");

            ObjectInputStream inObjetos = new ObjectInputStream(inArquivos);

            cachorrosArquivo = (List<Cachorro>) inObjetos.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Cachorro cachorro: cachorrosArquivo){
            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade() + " anos");
        }
    }
}
