package main.model;

import java.util.HashMap;
import java.util.Scanner;

public class TransactionScreen implements Displayable {
    private final Customer customer;
    private final HashMap<String, Customer> customerMap;
    Scanner scanner = new Scanner(System.in);
    public TransactionScreen(Customer customer, HashMap<String, Customer> customerMap) {
        this.customer = customer;
        this.customerMap = customerMap;
    }

    @Override
    public Displayable display() {
        System.out.println("\nWelcome " + customer.getName());
        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.print("Please choose option[3]: ");
        int selectedOpt = scanner.nextInt();
        switch (selectedOpt) {
            case 1:
                return new WithdrawScreen(customer, customerMap);
            case 2:
                return new FundTransferScreen(customer, customerMap);
            case 3:
                return new WelcomeScreen(customerMap);
            default:
        }
        return this;
    }
}
