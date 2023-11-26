package atividades;

import java.util.Scanner;

public class ex3 {
    public static int [] uniao(int [] vet, int [] vet1){
        int[] vet3 = new int[vet.length + vet1.length];
        for (int i = 0; i < vet.length; i++) {
            vet3[i] = vet[i];
        }

        for (int i = 0; i < vet1.length; i++) {
            vet3[vet.length + i] = vet1[i];
        }
        return vet3;
    }
    public static void mostrar(int[] vet, int[] vet1){
        int [] vet3 = uniao(vet,vet1);
        System.out.println("A união dos dois é " );
        for (int i = 0; i< vet3.length; i++){
            System.out.print(vet3[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int [] vet = new int[5];
        int [] vet1 = new int[5];

        System.out.println("Informe o array0: ");
         for (int i = 0; i< vet.length; i++){
             vet[i] = entrada.nextInt();
         }
         
        System.out.println("Informe o array1: ");
        for (int i = 0; i< vet.length; i++){
            vet1[i] = entrada.nextInt();
        }

        mostrar(vet, vet1);
    }
}
