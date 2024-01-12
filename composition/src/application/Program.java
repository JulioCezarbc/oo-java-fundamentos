package application;

import entites.Departament;
import entites.HourContract;
import entites.Worker;
import entitesEnum.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String departamento = entrada.nextLine();

        System.out.println("Dados do funcionario: ");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Level: ");
        String level = entrada.nextLine();

        System.out.print("Salario base: ");
        double salary = entrada.nextDouble();

        Worker worker = new Worker(nome, WorkerLevel.valueOf(level),salary,
                new Departament(departamento));

        System.out.print("Informe os contratos: ");
        int n = entrada.nextInt();

        for (int i = 1; i<=n; i++){
            System.out.println("Entre com o contrato " + i + ":");
            System.out.print("Data (DD/MM/YYYY): ");
            Date contractBase = sdf.parse(entrada.next());
            System.out.print("Valor por hora: ");
            double vph = entrada.nextDouble();
            System.out.print("Duração (horas): ");
            int hora = entrada.nextInt();
            HourContract contract = new HourContract(contractBase,vph,hora);
            worker.addContract(contract);
        }
        System.out.print("\nentre com mes e ano para calcular o salario (MM/yyyy): ");
        String mesAno = entrada.next();
        int mes = Integer.parseInt(mesAno.substring(0,2));
        int ano = Integer.parseInt(mesAno.substring(3));

        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartament().getName());
        System.out.println("Valor " + mesAno + ": " + worker.income(ano,mes));


    }
}
