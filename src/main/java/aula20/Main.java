package aula20;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("Bichinhos", "666");

        List<Empresa> emp = new ArrayList<>();
        emp.add(empresa);

        Funcionario f1 = new Funcionario("Carol", "Silva", "6661", 5000);
        Funcionario f2 = new Funcionario("Nico", "Lima", "6662", 7520.2);
        Funcionario f3 = new Funcionario("Maria", "Jose", "6663", 1250.9);
        Funcionario f4 = new Funcionario("Joao", "Maria", "6664", 2500);

        empresa.adicionarFuncionario(f1);
        empresa.adicionarFuncionario(f2);
        empresa.adicionarFuncionario(f3);
        empresa.adicionarFuncionario(f4);

        //System.out.println(empresa.toString());

        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("empresa.txt");

            ObjectOutputStream os = new ObjectOutputStream(fo);

            os.writeObject(emp);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Empresa> empresas = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("empresa.txt");

            ObjectInputStream is = new ObjectInputStream(fi);

            empresas = (List<Empresa>) is.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(empresas.toString());

        //salvando tudo com ; entre atributos
        String arquivoFunc = "empregados.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoFunc));
        ) {
            for (Funcionario funcionario : empresa.getFuncionarios()) {
                StringJoiner joiner = new StringJoiner(";");
                joiner.add(funcionario.getNome()).add(funcionario.getSobrenome()).add(funcionario.getDocumento()).add(String.valueOf(funcionario.getSalario()));
                bw.write(joiner.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
