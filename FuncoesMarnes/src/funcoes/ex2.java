package funcoes;

import java.util.Scanner;

public class ex2 {
    public static int MaiorNm(int[]nm){
        if (nm.length==0) System.out.println("O array esta vazio");

        int maior = nm[0];
        for (int numero : nm) {
            if (numero > maior) {
                maior = numero;
            }
        }

        return maior;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int [] nm = new int[4];
        for (int i = 0; i <4; i++){
            nm[i] = entrada.nextInt();
        }
        int maior = MaiorNm(nm);
        System.out.println("O maior número é: " + maior);
    }
}
