package atividades;

import java.util.Scanner;

public class ex4 {
    public static void diagonal(int mat [][]){
        System.out.print("Diagonal: | ");
        for (int i =0; i<4; i++){
            System.out.print(mat[i][i] + " | ");
        }
    }
    public static void diagonal1(int mat [][]){
        System.out.print("\nDiagonal secundaria: | ");
        for (int i =0; i<4; i++){
            System.out.print(mat[i][3 -i] + " | ");
        }
    }
    public static int[][] transposta(int[][] mat) {
        int[][] transposta = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                transposta[j][i] = mat[i][j];
            }
        }
        return transposta;

    }
    public static void mostrarMatriz(int[][] mat) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int [][] mat = new int[4][4];
        for (int L = 0; L<4; L++){
            for (int C = 0; C<4; C++){
                mat[L][C] = entrada.nextInt();
            }
        }

        diagonal(mat);
        diagonal1(mat);
        int[][] matrizTransposta = transposta(mat);
        System.out.println("\n\nMatriz Transposta:");
        mostrarMatriz(matrizTransposta);

    }
}
