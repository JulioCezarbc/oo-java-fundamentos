package Tr;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe um numero: ");
        int n = entrada.nextInt();

        System.out.println("O termo " + n + " da sequência de Fibonacci é: " + calculaFib(n));
    }

    public static int calculaFib(int x) {
        if (x <= 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            int a = 0, b = 1, fib = 0;
            for (int i = 2; i <= x; i++) {
                fib = a + b;
                a = b;
                b = fib;
            }
            return fib;
        }
    }
}