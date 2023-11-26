package funcoes;

import java.util.Scanner;

public class ex6 {
    public static int somaArray(int[] nm) {
        int soma = 0;
        for (int x : nm) {
            soma += x;
        }
        return soma;
    }

    public static void main(String[] args) {
        int[] nm = new int[5];
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe 5 números:");
        for (int i = 0; i < 5; i++) {
            nm[i] = entrada.nextInt();
        }

        int soma = somaArray(nm);
        System.out.println("A soma dos números é: " + soma);
    }
}