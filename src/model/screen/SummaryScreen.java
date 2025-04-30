package model.screen;

import model.Customer;
import model.Util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class SummaryScreen extends Screen {
    Double withdrawAmt = 0d;
    LocalDateTime transactionTimestamp;
    Scanner scanner = new Scanner(System.in);
    public SummaryScreen(Customer customer, HashMap<String, Customer> customerMap, Double withdrawAmt, LocalDateTime timestamp) {
        super(customer, customerMap);
        this.withdrawAmt = withdrawAmt;
        this.transactionTimestamp = timestamp;
    }

    @Override
    public Screen display() {
        displaySummary();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        System.out.print("Choose option[2]: ");
        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1 -> {
                return new TransactionScreen(customer, customerMap);
            }
            case 2 -> {
                return new WelcomeScreen(customer, customerMap);
            }
        }
        return this;
    }

    public void displaySummary() {
        System.out.println("\nSummary");
        System.out.println("Date: " + Util.getFormattedDateTime(this.transactionTimestamp));
        System.out.println("Withdraw : $" + withdrawAmt.intValue());
        System.out.println("Balance : $" + (int)customer.getBalance());
        System.out.println();
    }
}
