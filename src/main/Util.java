package main;

import main.model.Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class Util {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a", Locale.getDefault());
    public static double maxWithdrawAmount = 1000d;
    public static double maxTransferAmount = 1000d;
    public static double minTransferAmount = 1d;
    public static boolean onlyContainsNumber(String inputtedData) {
        return inputtedData.matches("[0-9]+");
    }

    public static boolean validateDigitLength(Integer length, String inputtedData) {
        return inputtedData.length() == length;
    }

    public static boolean validWithdrawalAmt(String withdrawAmt, Double customerBalance) {
        if (!Util.onlyContainsNumber(withdrawAmt)
                || (Double.parseDouble(withdrawAmt)%10 != 0
                && !moreThanMaxAmt(maxWithdrawAmount, Double.parseDouble(withdrawAmt)))) {
            System.out.println("Invalid amount");
            return false;
        }
        double withdrawDoubleAmt = Double.parseDouble(withdrawAmt);
        if (moreThanMaxAmt(maxWithdrawAmount, withdrawDoubleAmt)) {
            System.out.println("Maximum amount to withdraw is $" + (int)maxWithdrawAmount);
            return false;
        }
        return isSufficientBalance(customerBalance, withdrawDoubleAmt);
    }

    public static boolean isSufficientBalance(double customerBalance, double inputtedAmt) {
        if (customerBalance < inputtedAmt) {
            System.out.println("Insufficient balance $" + (int)customerBalance);
            return false;
        }
        return true;
    }

    public static boolean moreThanMaxAmt(double maxAmt, double inputtedAmt) {
        return inputtedAmt > maxAmt;
    }

    public static boolean lessThanMinAmt(double minAmt, double inputtedAmt) {
        return inputtedAmt < minAmt;
    }

    public static String getFormattedDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(formatter);
    }

    public static boolean accountNumberExisted(HashMap<String, Customer> customerMap, String accountNumber) {
        return customerMap.containsKey(accountNumber);
    }

    public static String getRandomStringNumber() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }
}
