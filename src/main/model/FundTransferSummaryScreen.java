package main.model;

import java.util.HashMap;
import java.util.Scanner;

public class FundTransferSummaryScreen extends Screen {
    private String destinationAccount;
    private Double transferAmount;
    private String referenceNumber;

    Scanner scanner = new Scanner(System.in);
    public FundTransferSummaryScreen(Customer customer, HashMap<String, Customer> customerMap, String destinationAccount,
                                     Double transferAmount, String referenceNumber) {
        super(customer, customerMap);
        this.destinationAccount = destinationAccount;
        this.transferAmount = transferAmount;
        this.referenceNumber = referenceNumber;
    }

    @Override
    public Screen display() {
        System.out.println("\nFund Transfer Summary");
        System.out.println("Destination Account : " + destinationAccount);
        System.out.println("Transfer Amount     : $" + transferAmount);
        System.out.println("Reference Number    : " + referenceNumber);
        System.out.println("Balance             : $" + customer.getBalance());
        System.out.println();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        System.out.print("Choose option[2]: ");
        int selectedOpt = scanner.nextInt();
        if (selectedOpt == 2) {
            return new WelcomeScreen(customer, customerMap);
        } else if (selectedOpt == 1) {
            return new TransactionScreen(customer, customerMap);
        } else {
            return this;
        }
    }
}
