package Tr;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe a base e o expoente: ");
        int x = entrada.nextInt();
        int y = entrada.nextInt();
        calcExp(x,y);
    }
    public static void calcExp(int x, int y){
        System.out.println(x + " elevado a " + y + " é " +  Math.pow(x,y));
    }
}
