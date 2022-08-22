package aula01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaTest {
//    public static void main(String[] args) {
//        Pessoa carol = new Pessoa("Carol", "Machado");
//        carol.setDataNascimento(LocalDate.of(1993, 6, 3));
//
//        carol.adicionarPessoas(carol);

        Pessoa p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
        List<String> listaNomes = new ArrayList<>();

        @BeforeEach
        void doBefore(){
            p1 = new Pessoa("Carol", "Machado");
            p1.setDataNascimento(LocalDate.of(1993, 6, 3));

            p2 = new Pessoa("Nicolas", "Bottega");
            p2.setDataNascimento(LocalDate.of(1998, 6, 1));

            p3 = new Pessoa("Ivo", "Ganda");
            p3.setDataNascimento(LocalDate.of(2000, 3, 23));

            p4 = new Pessoa("Ana", "Silva");
            p4.setDataNascimento(LocalDate.of(2000, 3, 23));

            p5 = new Pessoa("Job", "Belini");
            p5.setDataNascimento(LocalDate.of(2000, 3, 23));

            p6 = new Pessoa("Ted", "Santos");
            p6.setDataNascimento(LocalDate.of(2000, 3, 23));

            p7 = new Pessoa("Rob", "Scheneider");
            p7.setDataNascimento(LocalDate.of(2000, 3, 23));

            p8 = new Pessoa("Juliana", "Leao");
            p8.setDataNascimento(LocalDate.of(2018, 3, 23));

            p9 = new Pessoa("Roberta", "Braga");
            p9.setDataNascimento(LocalDate.of(2020, 3, 23));

            p10 = new Pessoa("Murilo", "Black");
            p10.setDataNascimento(LocalDate.of(2019, 3, 23));
        }

        @Test
        void imprimirObjetos(){
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            System.out.println(p3.toString());
            System.out.println(p4.toString());
            System.out.println(p5.toString());
            System.out.println(p6.toString());
            System.out.println(p7.toString());
            System.out.println(p8.toString());
            System.out.println(p9.toString());
            System.out.println(p10.toString());
        }

        @Test
        void adicionarColecao(){
            p1.adicionarPessoas(p1);
            p2.adicionarPessoas(p2);
            p3.adicionarPessoas(p3);
            p4.adicionarPessoas(p4);
            p5.adicionarPessoas(p5);
            p6.adicionarPessoas(p6);
            p7.adicionarPessoas(p7);
            p8.adicionarPessoas(p8);
            p9.adicionarPessoas(p9);
            p10.adicionarPessoas(p10);
        }

    }
//}
