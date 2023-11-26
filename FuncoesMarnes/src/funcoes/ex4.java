package funcoes;

import java.util.Scanner;

public class ex4 {

    public static int[] reverterArray(int [] nm){
        int[] arr2 = new int[nm.length];

        for (int i = 0; i < nm.length; i++) {
            arr2[i] = nm[nm.length - 1 - i];
        }

        return arr2;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int [] nm = new int[4];
        for (int i = 0; i <4; i++){
            nm[i] = entrada.nextInt();
        }
        int[] arrRevertido = reverterArray(nm);
        System.out.println("Array revertido:");
        for (int numero : arrRevertido) {
            System.out.print(numero + " ");
        }
    }
}
