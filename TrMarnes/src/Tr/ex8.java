package Tr;

import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um numero: ");
        int x = entrada.nextInt();
        somaNm(x);
    }

    public static void somaNm(int x) {
        int soma = 0;
        int y =x;
        while (x > 0) {
            int digito = x % 10;
            soma += digito;
            x /= 10;
        }
        System.out.println("A soma dos digitos " + y + " é " + soma);

    }
}