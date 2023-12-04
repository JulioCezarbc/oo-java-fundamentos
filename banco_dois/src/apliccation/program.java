package apliccation;
import entites.bank;
import java.time.LocalDate;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        bank inf;

        System.out.println("Informe seu nome : ");
        String name = entrada.next();

        System.out.println("Informe o ano, mês e dia de nascimento: ");
        System.out.println("Exemplo: '2004 11 25' ");
        int anoNascimento = entrada.nextInt();
        int mesNascimento = entrada.nextInt();
        int diaNascimento = entrada.nextInt();

        LocalDate dataNascimento = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);

        System.out.println("Gostaria de um deposito inicial ? sim/nao");
        String rep = entrada.next().toLowerCase();

        if (rep.equals("sim")){
            System.out.println("Informe o deposito inicial: ");
            double dep = entrada.nextDouble();
            inf = new bank(name,dataNascimento,dep);
        }
        else {
            inf = new bank(name,dataNascimento);
        }


        System.out.println(inf);

        System.out.println("\nInforme o valor do deposito: ");
        double dep = entrada.nextDouble();
        inf.deposito(dep);

        System.out.println(inf);

        System.out.println("\nInforme o valor do saque: ");
        double saq = entrada.nextDouble();
        inf.saque(saq);

        System.out.println(inf);

    }

}
