package model.screen;

import model.Customer;
import model.Util;

import java.util.HashMap;
import java.util.Scanner;

import static model.Util.onlyContainsNumber;
import static model.Util.validateDigitLength;

public class WelcomeScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    public WelcomeScreen(Customer customer, HashMap<String, Customer> customerMap) {
        super(customer, customerMap);
    }

    @Override
    public Screen display() {
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
                if (customer.isLoggedIn(customer.getPin(), inputtedPin)) {
                    return new TransactionScreen(customer, customerMap);
                }
            }
            System.out.println("Invalid Account Number/PIN");
        }
        return this;
    }

    private boolean validLoginInput(String type, String input) {
        if (validateDigitLength(6, input)) {
            if (onlyContainsNumber(input)) {
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
