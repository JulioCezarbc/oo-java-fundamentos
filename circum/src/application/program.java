package application;

import util.Calculator;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o valor do raio: ");
        double raio = entrada.nextDouble();

        double c = Calculator.circumference(raio);
        double v = Calculator.volume(raio);

        System.out.printf("Circuferencia: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", Calculator.PI);

    }

}
