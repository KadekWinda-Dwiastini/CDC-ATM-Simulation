package test.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.model.*;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class TransactionScreenTest extends TestCase {

    Scanner scanner = new Scanner(System.in);
    public void testDisplayWithdrawScreen() {
        String input = "1";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        TransactionScreen transactionScreen = TransactionScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(transactionScreen.display() instanceof WithdrawScreen);
    }

    public void testDisplayFundTransferScreen() {
        String input = "2";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        TransactionScreen transactionScreen = TransactionScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(transactionScreen.display() instanceof FundTransferScreen);
    }

    public void testDisplayWelcomeScreen() {
        String input = "3";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        TransactionScreen transactionScreen = TransactionScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(transactionScreen.display() instanceof WelcomeScreen);
    }

    public void testDisplayOthers() {
        String input = "4";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        TransactionScreen transactionScreen = TransactionScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(transactionScreen.display() instanceof TransactionScreen);
    }

    private static HashMap<String, Customer> getCustomerMap() {
        HashMap<String, Customer> customerListMap = new HashMap<>();
        customerListMap.put("112233", new Customer("John Doe", "012108", "112233",100));
        customerListMap.put("112244", new Customer("Jane Doe", "932012", "112244",30));
        return customerListMap;
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
