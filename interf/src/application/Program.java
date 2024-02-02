package application;

import model.entites.CarRental;
import model.entites.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalServices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String vehicle = entrada.nextLine();
        System.out.println("(dd/MM/yyyy HH:mm) ");
        System.out.print("Retirada: ");
        LocalDateTime start = LocalDateTime.parse(entrada.nextLine(), fmt);
        System.out.print("Retorno: ");
        LocalDateTime finish = LocalDateTime.parse(entrada.nextLine() ,fmt);

        CarRental carRental = new CarRental(start,finish, new Vehicle(vehicle));

        System.out.print("Entre com o preço por hora: ");
        double hora = entrada.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double dia = entrada.nextDouble();

        RentalServices rentalServices = new RentalServices(hora,dia,new BrazilTaxService());
        rentalServices.processInVoice(carRental);

        System.out.println("FATURA: ");
        System.out.println("Pagamento basico: " + carRental.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + carRental.getInvoice().getTax());
        System.out.println("Pagamento total: " + carRental.getInvoice().getTotalPayment());


    }
}
