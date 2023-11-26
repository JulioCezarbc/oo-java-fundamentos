package Final;

import not.student;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        student estudante = new student();
        System.out.println("Informe seu nome: ");
        estudante.nome = entrada.next();

        System.out.println("Informe suas notas: ");
        estudante.nota = entrada.nextDouble();
        estudante.nota1 = entrada.nextDouble();
        estudante.nota2 = entrada.nextDouble();

        estudante.NotaFinal(estudante.nota, estudante.nota1, estudante.nota2);
        estudante.finalN();

        System.out.println(estudante);

    }
}
