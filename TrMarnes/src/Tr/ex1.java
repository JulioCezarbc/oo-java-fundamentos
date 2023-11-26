package Tr;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um numero: ");
        int x = entrada.nextInt();
        verificador(x);
    }

    public static void verificador (int x) {
        if (x % 2 == 0){
            System.out.println("Par");
        }
        else {
            System.out.println("Impar");
        }
    }
}
