package Tr;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um numero: ");
        int x = entrada.nextInt();
        verificaPrimo(x);

    }
    public static void verificaPrimo (int x ){
        int cont=0;
            for (int j = 2; j< x; j++){
                if (x % j == 0) cont++;
            }
            if (cont == 0) System.out.println(x + " é primo");
            else System.out.println( x + " nao é primo");
        }
    }
