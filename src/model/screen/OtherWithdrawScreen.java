package model.screen;

import model.Customer;
import model.Displayable;
import model.Util;

import java.time.LocalDateTime;
import java.util.Scanner;

public class OtherWithdrawScreen extends Screen {
    Scanner scanner = new Scanner(System.in);
    public OtherWithdrawScreen(Customer customer) {
        super(customer);
    }

    @Override
    public Screen display() {
        System.out.println("Other Withdraw");
        System.out.print("Enter amount to withdraw: $");
        String withdrawAmt = scanner.nextLine();
        if (Util.validWithdrawalAmt(withdrawAmt, customer.getBalance())) {
            double withdrawAmtDouble = Double.parseDouble(withdrawAmt);
            customer.deductBalance(withdrawAmtDouble);
            return new SummaryScreen(customer, withdrawAmtDouble, LocalDateTime.now());
        };
        return new WithdrawScreen(customer);
    }
}
