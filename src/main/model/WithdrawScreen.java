package main.model;

import main.Util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class WithdrawScreen implements Displayable {
    private Customer customer;
    private final HashMap<String, Customer> customerMap;
    Scanner scanner;
    private static WithdrawScreen instance;

    private WithdrawScreen(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap) {
        this.customer = customer;
        this.customerMap = customerMap;
        this.scanner = scanner;
    }

    public static WithdrawScreen getInstance(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap) {
        if (instance == null) {
            instance = new WithdrawScreen(scanner, customer, customerMap);
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
        System.out.println("\n1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.print("Please choose option[5]: ");
        int selectedOpt = scanner.nextInt();
        scanner.nextLine();
        return switch (selectedOpt) {
            case 1 -> processWithdrawal(10d);
            case 2 -> processWithdrawal(50d);
            case 3 -> processWithdrawal(100d);
            case 4 -> OtherWithdrawScreen.getInstance(scanner, customer, customerMap);
            case 5 -> TransactionScreen.getInstance(scanner, customer, customerMap);
            default -> this;
        };
    }

    private Displayable processWithdrawal(Double amount) {
        if (Util.isSufficientBalance(customer.getBalance(), amount)) {
            customer.deductBalance(amount);
            return SummaryScreen.getInstance(scanner, customer, customerMap, amount, LocalDateTime.now());
        }
        return this;
    }
}
