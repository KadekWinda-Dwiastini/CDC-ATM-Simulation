package model.screen;

import model.Customer;
import model.Displayable;
import model.Util;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SummaryScreen extends Screen {
    Double withdrawAmt = 0d;
    LocalDateTime transactionTimestamp;
    public SummaryScreen(Customer customer, Double withdrawAmt, LocalDateTime timestamp) {
        super(customer);
        this.withdrawAmt = withdrawAmt;
        this.transactionTimestamp = timestamp;
    }

    @Override
    public Screen display() {
        Scanner scanner = new Scanner(System.in);
        displaySummary();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        System.out.print("Choose option[2]: ");
        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1 -> {
                return new TransactionScreen(customer);
            }
            case 2 -> {
                return new WelcomeScreen(customer);
            }
        }
        return this;
    }

    public void displaySummary() {
        System.out.println("Summary");
        System.out.println("Date: " + Util.getFormattedDateTime(this.transactionTimestamp));
        System.out.println("Withdraw : $" + withdrawAmt);
        System.out.println("Balance : $" + customer.getBalance());
        System.out.println();
    }
}
