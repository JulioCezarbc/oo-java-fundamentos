package atividades;

import java.util.Scanner;

public class ex1 {
     public static int totPares(int[] vet) {
     int soma = 0;
     for (int i = 0; i < vet.length; i++) {
     if (vet[i] % 2 == 0) {
     soma++;
     }
     }
     return soma;
     }
     public static int maiorVl(int[] veto){
     int maior = veto[0];
     for (int i = 0; i < veto.length; i++) {
     if (veto[i] > maior) {
     maior = veto[i];
     }
     }
     return maior;
     }
    public static int numerosIguais(int[] vetor1, int[] vetor2) {
        int totalIguais = 0;

        for (int i = 0; i < vetor1.length; i++) {
            for (int j = 0; j < vetor2.length; j++) {
                if (vetor1[i] == vetor2[j]) {
                    totalIguais++;
                }
            }
        }

        return totalIguais;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("Informe os numeros: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = entrada.nextInt();
        }
        System.out.println("O total de pares é " + totPares(arr));

        int[] vet = new int[5];
        System.out.println("Informe os numeros: ");
        for (int i = 0; i < vet.length; i++) {
            vet[i] = entrada.nextInt();
        }
        System.out.println("O maior valor é " + maiorVl(vet));

        int[] vet1 = new int[5];
        int[] vet2 = new int[5];
        System.out.println("Digite os valores do primeiro vetor:");
        for (int i = 0; i < vet1.length; i++) {
            vet1[i] = entrada.nextInt();
        }

        System.out.println("Digite os valores do segundo vetor:");
        for (int i = 0; i < vet2.length; i++) {
            vet2[i] = entrada.nextInt();
        }

        int valoresIguais = numerosIguais(vet1, vet2);

        System.out.print("O valor total é: " + valoresIguais);
    }
}
