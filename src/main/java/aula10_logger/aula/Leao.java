package aula10_logger.aula;

import org.apache.log4j.Logger;

public class Leao {
    
    //inicializando logger
    private static final Logger logger = Logger.getLogger(Leao.class);

    private String nome;
    private int idade;
    private boolean eAlfa;

    public Leao(String nome, int idade, boolean eAlfa) {
        this.nome = nome;
        this.idade = idade;
        this.eAlfa = eAlfa;
    }

    public void correr(){
        logger.info("O leão " + nome + " está correndo!");
    }

    public void eMaiorQue10() throws Exception{
        if(idade > 10 && eAlfa){
            logger.info("O leão " + nome + " tem mais de 10 anos e é alfa");
        } else{
            logger.info("O leão " + nome + " tem menos de 10 anos ou não é alfa (ou ambos)");
        }
        if(idade < 0){
            logger.error("Não existe idade menor que 0");
            throw new Exception();
        }
    }
}
