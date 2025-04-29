package model.screen;


import model.Customer;
import model.Util;

import java.time.LocalDateTime;
import java.util.Scanner;

public class WithdrawScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    public WithdrawScreen(Customer customer) {
        super(customer);
    }

    @Override
    public Screen display() {
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.println("Please choose option[5]");
        int selectedOpt = scanner.nextInt();
        return switch (selectedOpt) {
            case 1 -> processWithdrawal(10d);
            case 2 -> processWithdrawal(50d);
            case 3 -> processWithdrawal(100d);
            case 4 -> new OtherWithdrawScreen(customer);
            case 5 -> new TransactionScreen(customer);
            default -> this;
        };
    }

    private Screen processWithdrawal(Double amount) {
        customer.deductBalance(amount);
        return new SummaryScreen(customer, amount, LocalDateTime.now());
    }
}
