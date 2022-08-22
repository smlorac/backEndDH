package aula07_flyweightPattern.aula;

import aula07_flyweightPattern.aula.factory.ComputerFactory;
import aula07_flyweightPattern.aula.model.Computer;

public class Main {
    public static void main(String[] args) {

        ComputerFactory computerFactory = new ComputerFactory();

        Computer mac1 = computerFactory.getComputer(16, 500);
        Computer windows = computerFactory.getComputer(2, 256);
        Computer mac2 = computerFactory.getComputer(16, 500);

        System.out.println(mac2.toString());
        System.out.println(mac1.toString());
        System.out.println(windows.toString());
    }
}
