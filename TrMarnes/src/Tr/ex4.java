package Tr;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x = entrada.nextInt();
        Tabuada(x);
    }
    public static void Tabuada(int x ){
        for (int i = 1; i<= 10; i++){
            System.out.println(x + " x " + i +" = " + x*i );
        }

    }
}
