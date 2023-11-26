package Tr;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x = entrada.nextInt();
        calcularFat(x);
    }
    public static void calcularFat(int x){
        if (x <= 0 ){
            System.out.println("ERROR");
        }else for (int i = x-1; i> 0; i--){
            x *=  i;
            System.out.println(x + " x " +  i + " = " + x );

        }
    }
}
