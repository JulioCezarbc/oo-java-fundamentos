package model.services;

import model.entites.CarRental;
import model.entites.Invoice;

import java.time.Duration;

public class RentalServices {
    private double pricePerHour;
    private double pricePerDay;
    private TaxService taxService;

    public RentalServices(double pricePerHour, double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }
    public void processInVoice(CarRental carRental){
        double min = Duration.between(carRental.getStart(),carRental.getFinish()).toMinutes();
        double hr = min /60.0;

        double payment;
        if (hr <=12) payment = pricePerHour * Math.ceil(hr);
        else payment = pricePerDay * Math.ceil(hr / 24.0);

        double tax = taxService.tax(payment);

        carRental.setInvoice(new Invoice(payment,tax));
    }
}
