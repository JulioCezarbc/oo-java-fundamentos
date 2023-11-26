package funcoes;

import java.util.Scanner;

public class ex3 {
    public static int MenorNm(int[]nm){
        if (nm.length==0) System.out.println("O array esta vazio");

        int menor = nm[0];
        for (int numero : nm) {
            if (numero < menor) {
                menor = numero;
            }
        }

        return menor;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int [] nm = new int[4];
        for (int i = 0; i <4; i++){
            nm[i] = entrada.nextInt();
        }
        int maior = MenorNm(nm);
        System.out.println("O menor número é: " + maior);
    }

}
