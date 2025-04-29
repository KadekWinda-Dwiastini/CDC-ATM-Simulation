package model.screen;

import model.Customer;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class FundTransferScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    public FundTransferScreen(Customer customer) {
        super(customer);
    }

    @Override
    public Screen display() {
        System.out.println("Please enter destination account and press enter to continue or ");
        System.out.println("press cancel (Esc) to go back to Transaction: ");
        int inputtedAccountNumber = scanner.nextInt();
        return this;
    }

    public void displayScreen2() {
        System.out.println("Please enter transfer amount and press enter to contine or ");
        System.out.println("press cancel (Esc) to go back to Transaction: " );
    }

    public void displayScreen3() {
        System.out.println("Reference Number: ");
        System.out.println("press enter continue or press cancel (Esc) to go back to transaction: " );
    }

    public void displayScreen4() {
        System.out.println("Transfer Confirmation ");
        System.out.println("Destination Account     : " );
        System.out.println("Transfer Amount         : " );
        System.out.println("Reference Number        : " );
        System.out.println();
        System.out.println("1. Confirm Trx" );
        System.out.println("2. Cancel Trx" );
        System.out.println("Choose option[2]: " );
    }
}
