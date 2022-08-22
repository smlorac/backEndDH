package aula20_serializacao.mesa;

import aula13_consultasETransacoes.aula.Conta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato("Carol", "carol@email.com", "99990001");
        Contato contato2 = new Contato("Nico", "nico@email.com", "98990001");
        Contato contato3 = new Contato("Maria", "maria@email.com", "91336666");

        contatos.add(contato1);
        contatos.add(contato2);
        contatos.add(contato3);

        FileOutputStream out = null;

        try{
            out = new FileOutputStream("contatos.txt");

            ObjectOutputStream outObj = new ObjectOutputStream(out);

            outObj.writeObject(contatos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Contato> contatosSalvos = null;

        FileInputStream in = null;

        try{
            in = new FileInputStream("contatos.txt");

            ObjectInputStream inObj = new ObjectInputStream(in);

            contatosSalvos = (List<Contato>) inObj.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Contato contato: contatosSalvos){
            System.out.println(contato.toString());
        }
    }
}
