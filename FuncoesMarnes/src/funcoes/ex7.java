package funcoes;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


        int[] numeros = new int[4];


        for (int i = 0; i < 4; i++) {
            numeros[i] = entrada.nextInt();
        }

        int produto = calcularProduto(numeros);
        System.out.println("O produto dos elementos do array é: " + produto);
    }

    public static int calcularProduto(int[] array) {
        int produto = 1;

        for (int numero : array) {
            produto *= numero;
        }

        return produto;
    }
}
