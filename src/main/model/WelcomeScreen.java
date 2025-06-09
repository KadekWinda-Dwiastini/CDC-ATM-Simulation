package main.model;

import main.Util;

import java.util.HashMap;
import java.util.Scanner;


public class WelcomeScreen implements Displayable {
    private final HashMap<String, Customer> customerMap;
    Scanner scanner = new Scanner(System.in);

    public WelcomeScreen(HashMap<String, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    @Override
    public Displayable display() {
        System.out.print("\nEnter Account Number: ");
        String accountNumber = scanner.nextLine();
        if (validLoginInput("Account Number", accountNumber)) {
            System.out.print("Enter PIN: ");
            String inputtedPin = scanner.nextLine();
            if (!validLoginInput("PIN", inputtedPin)) {
                return this;
            }
            if (Util.accountNumberExisted(customerMap, accountNumber)) {
                Customer customer = customerMap.get(accountNumber);
                if (customer.isLoggedIn(inputtedPin)) {
                    return new TransactionScreen(customer, customerMap);
                }
            }
            System.out.println("Invalid Account Number/PIN");
        }
        return this;
    }

    private boolean validLoginInput(String type, String input) {
        if (Util.validateDigitLength(6, input)) {
            if (Util.onlyContainsNumber(input)) {
                return true;
            }
            printErrorNotContainsNumber(type);
            return false;
        }
        printLengthError(type);
        return false;
    }

    private void printErrorNotContainsNumber(String obj) {
        System.out.println(obj + " should only contains numbers");
    }

    public static void printLengthError(String obj) {
        System.out.println(obj + " should have 6 digits length");
    }
}
