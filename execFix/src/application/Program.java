package application;

import entites.Contract;
import entites.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Entre com os dados do contrato");
        System.out.print("Numero: ");
        int nm = entrada.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(entrada.next(), fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = entrada.nextDouble();

        Contract contract = new Contract(nm,date,totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        int pc = entrada.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract,pc);


        for (Installment installment: contract.getInstallment()){
            System.out.println(installment);
        }


    }
}
