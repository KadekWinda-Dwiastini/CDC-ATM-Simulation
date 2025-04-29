package model.screen;

import model.Customer;

public class FundTransferSummaryScreen extends Screen {
    public FundTransferSummaryScreen(Customer customer) {
        super(customer);
    }

    @Override
    public Screen display() {
        System.out.println("Fund Transfer Summary");
        System.out.println("Destination Account         : ");
        System.out.println("Transfer Amount             :");
        System.out.println("Reference Number            :");
        System.out.println("Balance                     :");
        System.out.println();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        System.out.println("Choose option[2]");
        return this;
    }
}
