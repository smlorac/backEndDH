package aula10_logger.aula;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception{

        Leao leao = new Leao("nico", 12, true);
        Leao leao1 = new Leao("carol", 8, true);

        Tigre tigre = new Tigre("tigrao", -1);

        //alternativa para configurar o log4j.properties
        BasicConfigurator.configure();

        leao.correr();
        leao.eMaiorQue10();
        leao1.eMaiorQue10();
        tigre.eMaiorQue10();
        //poderiamos ter feito isso com try catch
    }
}
