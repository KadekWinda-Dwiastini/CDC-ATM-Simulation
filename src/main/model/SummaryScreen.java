package main.model;

import main.Util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class SummaryScreen implements Displayable {
    private Customer customer;
    private final HashMap<String, Customer> customerMap;
    Double withdrawAmt = 0d;
    LocalDateTime transactionTimestamp;
    Scanner scanner;
    private static SummaryScreen instance;

    private SummaryScreen(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap, Double withdrawAmt, LocalDateTime timestamp) {
        this.customer = customer;
        this.customerMap = customerMap;
        this.withdrawAmt = withdrawAmt;
        this.transactionTimestamp = timestamp;
        this.scanner = scanner;
    }

    public static SummaryScreen getInstance(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap, Double withdrawAmt, LocalDateTime timestamp) {
        if (instance == null) {
            instance = new SummaryScreen(scanner, customer, customerMap, withdrawAmt, timestamp);
        } else {
            instance.modifyData(customer, withdrawAmt, timestamp);
        }
        return instance;
    }

    private void modifyData(Customer customer, Double withdrawAmt, LocalDateTime timestamp) {
        this.customer = customer;
        this.withdrawAmt = withdrawAmt;
        this.transactionTimestamp = timestamp;
    }

    @Override
    public Displayable display() {
        displaySummary();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        System.out.print("Choose option[2]: ");
        int selectedOption = scanner.nextInt();
        scanner.nextLine();
        switch (selectedOption) {
            case 1 -> {
                return TransactionScreen.getInstance(scanner, customer, customerMap);
            }
            case 2 -> {
                return WelcomeScreen.getInstance(scanner);
            }
        }
        return this;
    }

    private void displaySummary() {
        System.out.println("\nSummary");
        System.out.println("Date: " + Util.getFormattedDateTime(this.transactionTimestamp));
        System.out.println("Withdraw : $" + withdrawAmt.intValue());
        System.out.println("Balance : $" + (int)customer.getBalance());
        System.out.println();
    }
}
