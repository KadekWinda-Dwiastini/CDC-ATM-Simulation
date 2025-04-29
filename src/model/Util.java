package model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Util {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a", Locale.getDefault());
    public static boolean onlyContainsNumber(String inputtedData) {
        return inputtedData.matches("[0-9]+");
    }

    public static boolean validateDigitLength(Integer length, String inputtedData) {
        return inputtedData.length() == length;
    }

    public static boolean validWithdrawalAmt(String withdrawAmt, Double customerBalance) {
        if (!Util.onlyContainsNumber(withdrawAmt) || Double.parseDouble(withdrawAmt)%10 != 0) {
            System.out.println("Invalid amount");
            return false;
        }
        double withdrawDoubleAmt = Double.parseDouble(withdrawAmt);
        if (withdrawDoubleAmt > 1000) {
            System.out.println("Maximum amount to withdraw is $1000");
            return false;
        }
        if (customerBalance < withdrawDoubleAmt) {
            System.out.println("Insufficient balance $" + withdrawDoubleAmt);
            return false;
        }
        return true;
    }

    public static String getFormattedDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(formatter);
    }
}
