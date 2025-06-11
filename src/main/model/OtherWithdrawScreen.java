package main.model;

import main.Util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class OtherWithdrawScreen implements Displayable {
    private Customer customer;
    private final HashMap<String, Customer> customerMap;
    Scanner scanner;
    private static OtherWithdrawScreen instance;

    private OtherWithdrawScreen(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap) {
        this.customer = customer;
        this.customerMap = customerMap;
        this.scanner = scanner;
    }

    public static OtherWithdrawScreen getInstance(Scanner scanner, Customer customer, HashMap<String, Customer> customerMap) {
        if (instance == null) {
            instance = new OtherWithdrawScreen(scanner, customer, customerMap);
        } else {
            instance.modifyData(customer);
        }
        return instance;
    }

    private void modifyData(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Displayable display() {
        System.out.println("\nOther Withdraw");
        System.out.print("Enter amount to withdraw: $");
        String withdrawAmt = scanner.nextLine();
        if (Util.validWithdrawalAmt(withdrawAmt, customer.getBalance())) {
            double withdrawAmtDouble = Double.parseDouble(withdrawAmt);
            customer.deductBalance(withdrawAmtDouble);
            return SummaryScreen.getInstance(scanner, customer, customerMap, withdrawAmtDouble, LocalDateTime.now());
        };
        return WithdrawScreen.getInstance(scanner, customer, customerMap);
    }
}
