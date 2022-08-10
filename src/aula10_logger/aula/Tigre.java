package aula10_logger.aula;

import org.apache.log4j.Logger;


public class Tigre {

    private static final Logger logger = Logger.getLogger(Tigre.class);
    //poderiamos ter usado Leao.class também

    private String nome;
    private int idade;

    public Tigre(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void correr(){
        logger.info("O tigre " + nome + " está correndo!");
    }

    public void eMaiorQue10() throws Exception{
        if(idade > 10){
            logger.info("O tigre " + nome + " tem mais de 10 anos");
        } else{
            logger.info("O tigre " + nome + " tem menos de 10 anos)");
        }
        if(idade < 0){
            logger.error("Não existe idade menor que 0");
            throw new Exception();
        }
    }
}
