package services;

import entites.Contract;
import entites.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }
    public void processContract(Contract contract, int months){
        double basic = contract.getTotalValue() / months;
        for (int i = 1; i<= months; i++){
            LocalDate date = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(basic,i);
            double tax = onlinePaymentService.paymentFee(basic + interest);
            double qota = basic + interest + tax;

            contract.getInstallment().add(new Installment(date,qota));
        }
    }
}
