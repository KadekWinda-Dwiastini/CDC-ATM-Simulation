package main.model;

import main.Util;

import java.util.HashMap;
import java.util.Scanner;

public class FundTransferScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    public FundTransferScreen(Customer customer, HashMap<String, Customer> customerMap) {
        super(customer, customerMap);
    }

    @Override
    public Screen display() {
        System.out.println("\nPlease enter destination account and press enter to continue or ");
        System.out.print("type Esc to go back to Transaction: ");
        String inputtedAccountNumber = scanner.nextLine();
        if (inputtedAccountNumber.equalsIgnoreCase("Esc")) {
            return new TransactionScreen(customer, customerMap);
        }
        return displayScreen2(inputtedAccountNumber);
    }

    public Screen displayScreen2(String inputtedAccountNumber) {
        System.out.println("\nPlease enter transfer amount and press enter to continue or ");
        System.out.print("type Esc to go back to Transaction: $" );
        String inputtedAmountString = scanner.nextLine();
        if (inputtedAmountString.equalsIgnoreCase("Esc")) {
            return new TransactionScreen(customer, customerMap);
        }
        return displayScreen3(inputtedAccountNumber, inputtedAmountString);
    }

    public Screen displayScreen3(String inputtedAccountNumber, String inputtedAmountString) {
        String referenceNumber = Util.getRandomStringNumber();
        System.out.println("\nReference Number: " + referenceNumber );
        System.out.print("press enter to continue or type Esc to go back to transaction: " );
        String optionSelected = scanner.nextLine();
        switch (optionSelected) {
            case "" -> {
                return displayScreen4(inputtedAccountNumber, inputtedAmountString, referenceNumber);
            }
            case "Esc" -> {
                return new TransactionScreen(customer, customerMap);
            }
        }
        return this;
    }

    public Screen displayScreen4(String inputtedAccountNumber, String inputtedAmountString, String referenceNumber) {
        System.out.println("\nTransfer Confirmation ");
        System.out.println("Destination Account : " + inputtedAccountNumber);
        System.out.println("Transfer Amount     : $" + inputtedAmountString);
        System.out.println("Reference Number    : " + referenceNumber);
        System.out.println();
        System.out.println("1. Confirm Trx" );
        System.out.println("2. Cancel Trx" );
        System.out.print("Choose option[2]: " );

        int selectedOpt = scanner.nextInt();
        if (selectedOpt == 2) {
            return new TransactionScreen(customer, customerMap);
        } else if (selectedOpt != 1) {
            return this;
        }

        if (!Util.onlyContainsNumber(inputtedAccountNumber) || !Util.accountNumberExisted(customerMap, inputtedAccountNumber)) {
            System.out.println("Invalid account");
            return returnToTransactionScreen();
        }
        if (!Util.onlyContainsNumber(inputtedAmountString)) {
            System.out.println("Invalid amount");
            return returnToTransactionScreen();
        }
        double inputtedAmt = Double.parseDouble(inputtedAmountString);
        if (Util.moreThanMaxAmt(Util.maxTransferAmount, inputtedAmt)) {
            System.out.println("Maximum amount to transfer is $" + (int) Util.maxTransferAmount);
        } else if (Util.lessThanMinAmt(Util.minTransferAmount, inputtedAmt)) {
            System.out.println("Minimum amount to transfer is $" + (int) Util.minTransferAmount);
        } else if (Util.isSufficientBalance(customer.getBalance(), inputtedAmt)) {
            customer.deductBalance(inputtedAmt);
            Customer destinationCustomer = customerMap.get(inputtedAccountNumber);
            destinationCustomer.addBalance(inputtedAmt);
            return new FundTransferSummaryScreen(customer, customerMap, inputtedAccountNumber, inputtedAmt, referenceNumber);
        }
        return returnToTransactionScreen();
    }

    private Screen returnToTransactionScreen() {
        return new TransactionScreen(customer, customerMap);
    }
}
