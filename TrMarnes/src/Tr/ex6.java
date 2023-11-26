package Tr;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um numero: ");
        int x = entrada.nextInt();
        somaPar(x);

    }
    public static void somaPar(int x){
        int tot =0;
        for (int i = 2;i<=x;i++){
           if (i % 2 == 0){
               tot+=i;
            }
        }
        System.out.println("A soma de todos os pares é " + tot);
    }
}
