package application;

import modelEntites.Reservation;
import modelEx.DomainEx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Quarto ");
            int numero = entrada.nextInt();

            System.out.print("CheckIn date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(entrada.next());

            System.out.print("CheckOut date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(entrada.next());

            Reservation reservation = new Reservation(numero, checkIn, checkOut);
            System.out.println("Reservation " + reservation);


            System.out.println("\nEntre com a data atualizada: ");
            System.out.print("Checkin date: ");
            checkIn = sdf.parse(entrada.next());

            System.out.print("CheckOut date: ");
            checkOut = sdf.parse(entrada.next());

            reservation.updateDates(checkIn,checkOut);
            System.out.println("Reservation " + reservation);
        }catch (ParseException e ){
            System.out.println("Invalid date formate ");
        }catch (DomainEx e ){
            System.out.println(e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Erro inesperado ");
        }
    }
}
