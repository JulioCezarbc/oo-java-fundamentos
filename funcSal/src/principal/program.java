package principal;

import cont.imp;

import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        imp inf = new imp();

        System.out.println("Informe seu nome: ");
        inf.nome = entrada.next().toUpperCase();

        System.out.println("Informe seu salario bruto: ");
        inf.salario = entrada.nextDouble();

        System.out.println(inf.nome + " seu salario liquido é: " + inf.salarioLiq());

        System.out.println();
        System.out.println("Informe seu setor: ");
        inf.setor = entrada.next();

        System.out.println(inf);

    }
}
