package aplication;
import java.util.Scanner;
import util.CurrencyConverter;
public class program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qual a cotação do dolar ?");
        double cot = entrada.nextDouble();

        System.out.println("Qual o valor a ser comprado: ");
        double value = entrada.nextDouble();

        double v = CurrencyConverter.convert(cot,value);

        System.out.printf("O valor a ser pago é %.2f%n",v );
    }
}
