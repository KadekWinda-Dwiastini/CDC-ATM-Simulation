package model.screen;

import model.Customer;

import java.util.HashMap;
import java.util.Scanner;

import static model.Util.onlyContainsNumber;
import static model.Util.validateDigitLength;

public class WelcomeScreen extends Screen {
    HashMap<String, Customer> customerMap;

    public WelcomeScreen(Customer customer) {
        super(customer);
        this.customerMap = initializeData();
    }

    private static HashMap<String, Customer> initializeData() {
        HashMap<String, Customer> customerListMap = new HashMap<>();
        customerListMap.put("112233", new Customer("John Doe", "012108", "112233",100));
        customerListMap.put("112244", new Customer("Jane Doe", "932012", "112244",30));
        return customerListMap;
    }

    @Override
    public Screen display() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        if (validLoginInput("Account Number", accountNumber)) {
            System.out.print("Enter PIN: ");
            String inputtedPin = scanner.nextLine();
            if (validLoginInput("PIN", inputtedPin)) {
                if (!customerMap.containsKey(accountNumber)) {
                    System.out.println("Invalid Account Number/PIN");
                    return this;
                }
                Customer customer = customerMap.get(accountNumber);
                if (!customer.isLoggedIn(customer.getPin(), inputtedPin)) {
                    System.out.println("Invalid Account Number/PIN");
                    return this;
                }
                return new TransactionScreen(customer);
            }
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
