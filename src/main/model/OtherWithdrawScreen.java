package main.model;

import main.Util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class OtherWithdrawScreen extends Screen {
    Scanner scanner = new Scanner(System.in);
    public OtherWithdrawScreen(Customer customer, HashMap<String, Customer> customerMap) {
        super(customer, customerMap);
    }

    @Override
    public Screen display() {
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
