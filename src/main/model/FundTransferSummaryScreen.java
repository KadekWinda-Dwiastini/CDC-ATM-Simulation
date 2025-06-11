package main.model;

import java.util.HashMap;
import java.util.Scanner;

public class FundTransferSummaryScreen implements Displayable {
    private Customer customer;
    private final HashMap<String, Customer> customerMap;
    private String destinationAccount;
    private Double transferAmount;
    private String referenceNumber;
    private static FundTransferSummaryScreen instance;
    Scanner scanner;

    private FundTransferSummaryScreen(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap, String destinationAccount,
                                     Double transferAmount, String referenceNumber) {
        this.customer = customer;
        this.customerMap = customerMap;
        this.destinationAccount = destinationAccount;
        this.transferAmount = transferAmount;
        this.referenceNumber = referenceNumber;
        this.scanner = scanner;
    }

    public static FundTransferSummaryScreen getInstance(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap, String destinationAccount,
                                                        Double transferAmount, String referenceNumber) {
        if (instance == null) {
            instance = new FundTransferSummaryScreen(scanner, customer, customerMap, destinationAccount, transferAmount, referenceNumber);
        } else {
            instance.modifyData(customer, destinationAccount, transferAmount, referenceNumber);
        }
        return instance;
    }

    private void modifyData(Customer customer, String destinationAccount, Double transferAmount, String referenceNumber) {
        this.destinationAccount = destinationAccount;
        this.transferAmount = transferAmount;
        this.referenceNumber = referenceNumber;
        this.customer = customer;
    }

    @Override
    public Displayable display() {
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
        scanner.nextLine();
        if (selectedOpt == 2) {
            return WelcomeScreen.getInstance(scanner);
        } else if (selectedOpt == 1) {
            return TransactionScreen.getInstance(scanner, customer, customerMap);
        } else {
            return this;
        }
    }
}
