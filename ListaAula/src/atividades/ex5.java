package atividades;

import java.util.Scanner;

public class ex5 {
    public static void preencher(int[][] mat) {
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = entrada.nextInt();
            }
        }
    }

    public static boolean ehQuadradoMagico(int[][] mat) {
        // Calcular a soma da primeira linha

        int somaReferencia = 0;
        for (int j = 0; j < 3; j++) {
            somaReferencia += mat[0][j];
        }

        // Verificar soma das linhas
        for (int i = 1; i < 3; i++) {
            int somaLinha = 0;
            for (int j = 0; j < 3; j++) {
                somaLinha += mat[i][j];
            }
            if (somaLinha != somaReferencia) {
                return false;
            }
        }

        // Verificar soma das colunas
        for (int j = 0; j < 3; j++) {
            int somaColuna = 0;
            for (int i = 0; i < 3; i++) {
                somaColuna += mat[i][j];
            }
            if (somaColuna != somaReferencia) {
                return false;
            }
        }

        // Verificar soma da diagonal principal
        int somaDiagonalPrincipal = mat[0][0] + mat[1][1] + mat[2][2];
        if (somaDiagonalPrincipal != somaReferencia) {
            return false;
        }

        // Verificar soma da diagonal secundária
        int somaDiagonalSecundaria = mat[0][2] + mat[1][1] + mat[2][0];
        return somaDiagonalSecundaria == somaReferencia;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[][] mat = new int[3][3];
        preencher(mat);
        if (ehQuadradoMagico(mat)) {
            System.out.println("É um quadrado mágico!");
        } else {
            System.out.println("Não é um quadrado mágico.");
        }
    }
}