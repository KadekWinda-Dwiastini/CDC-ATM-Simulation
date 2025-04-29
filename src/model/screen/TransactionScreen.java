package model.screen;

import model.Customer;

import java.util.Scanner;

public class TransactionScreen extends Screen {

    public TransactionScreen(Customer customer) {
        super(customer);
    }

    @Override
    public Screen display() {
        System.out.println("Welcome " + customer.getName());
        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.println("Please choose option[3]:");
        Scanner scanner = new Scanner(System.in);
        int selectedOpt = scanner.nextInt();
        switch (selectedOpt) {
            case 1:
                return new WithdrawScreen(customer);
            case 2:
                return new FundTransferScreen(customer);
            case 3:
                return new WelcomeScreen(null);
            default:
        }
        return this;
    }
}
