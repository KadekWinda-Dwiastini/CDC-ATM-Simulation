package main.model;

import main.Util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class OtherWithdrawScreen implements Displayable {
    private final Customer customer;
    private final HashMap<String, Customer> customerMap;
    Scanner scanner = new Scanner(System.in);
    public OtherWithdrawScreen(Customer customer, HashMap<String, Customer> customerMap) {
        this.customer = customer;
        this.customerMap = customerMap;
    }

    @Override
    public Displayable display() {
        System.out.println("\nOther Withdraw");
        System.out.print("Enter amount to withdraw: $");
        String withdrawAmt = scanner.nextLine();
        if (Util.validWithdrawalAmt(withdrawAmt, customer.getBalance())) {
            double withdrawAmtDouble = Double.parseDouble(withdrawAmt);
            customer.deductBalance(withdrawAmtDouble);
            return new SummaryScreen(customer, customerMap, withdrawAmtDouble, LocalDateTime.now());
        };
        return new WithdrawScreen(customer, customerMap);
    }
}
