package main.model;

import java.util.HashMap;
import java.util.Scanner;

public class TransactionScreen implements Displayable {
    private Customer customer;
    private final Scanner scanner;
    private final HashMap<String, Customer> customerMap;
    private static TransactionScreen instance;

    private TransactionScreen(Scanner scanner, HashMap<String, Customer> customerMap, Customer customer) {
        this.customerMap = customerMap;
        this.scanner = scanner;
        this.customer = customer;
    }

    public static TransactionScreen getInstance(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap) {
        if (instance == null) {
            instance = new TransactionScreen(scanner, customerMap, customer);
        } else {
            instance.modifyCustomer(customer);
        }
        return instance;
    }

    private void modifyCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Displayable display() {
        System.out.println("\nWelcome " + customer.getName());
        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.print("Please choose option[3]: ");
        int selectedOpt = scanner.nextInt();
        scanner.nextLine();
        switch (selectedOpt) {
            case 1:
                return WithdrawScreen.getInstance(scanner, customer, customerMap);
            case 2:
                return FundTransferScreen.getInstance(scanner, customer, customerMap);
            case 3:
                return WelcomeScreen.getInstance(scanner);
        }
        return this;
    }
}
