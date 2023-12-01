package apliccation;

import entites.bank;

import java.time.LocalDate;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);

        System.out.println("Informe seu nome : ");
        String name = entrada.next();

        System.out.println("Informe o ano de nascimento: ");
        int anoNascimento = entrada.nextInt();

        System.out.println("Informe o mês de nascimento: ");
        int mesNascimento = entrada.nextInt();

        System.out.println("Informe o dia de nascimento: ");
        int diaNascimento = entrada.nextInt();

        LocalDate dataNascimento = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);

        System.out.println("Informe o deposito inicial: ");
        double dep = entrada.nextDouble();

        bank inf = new bank(name,dataNascimento,dep);

        System.out.println(inf);

        System.out.println("\nInforme o valor do deposito: ");
        dep = entrada.nextDouble();
        inf.deposito(dep);

        System.out.println(inf);

        System.out.println("\nInforme o valor do saque: ");
        double saq = entrada.nextDouble();
        inf.saque(saq);

        System.out.println(inf);

    }

}
