package funcoes;

import java.util.Scanner;

public class ex1 {

    public static double calcMd(double[]nm){
        if (nm.length == 0) {
            return 0.0;
        }
        double soma =0.0;
        for (double x : nm){
            soma+= x ;
        }
        return soma / nm.length;

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double [] nm = new double[4];
        for (int i = 0; i <4; i++){
            nm[i] = entrada.nextDouble();
        }
        double media = calcMd(nm);
        System.out.println("A media é " + media);


    }

}
