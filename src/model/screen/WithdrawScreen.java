package model.screen;


import model.Customer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

import static model.Util.isSufficientBalance;

public class WithdrawScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    public WithdrawScreen(Customer customer, HashMap<String, Customer> customerMap) {
        super(customer, customerMap);
    }

    @Override
    public Screen display() {
        System.out.println("\n1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.print("Please choose option[5]: ");
        int selectedOpt = scanner.nextInt();
        return switch (selectedOpt) {
            case 1 -> processWithdrawal(10d);
            case 2 -> processWithdrawal(50d);
            case 3 -> processWithdrawal(100d);
            case 4 -> new OtherWithdrawScreen(customer, customerMap);
            case 5 -> new TransactionScreen(customer, customerMap);
            default -> this;
        };
    }

    private Screen processWithdrawal(Double amount) {
        if (isSufficientBalance(customer.getBalance(), amount)) {
            customer.deductBalance(amount);
            return new SummaryScreen(customer, customerMap, amount, LocalDateTime.now());
        }
        return this;
    }
}
