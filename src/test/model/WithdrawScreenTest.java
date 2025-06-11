package test.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.model.*;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class WithdrawScreenTest extends TestCase {
    Scanner scanner = new Scanner(System.in);

    public void testDisplayWithdraw10d() {
        String input = "1";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WithdrawScreen withdrawScreen = WithdrawScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(withdrawScreen.display() instanceof SummaryScreen);
    }

    public void testDisplayWithdraw50d() {
        String input = "2";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WithdrawScreen withdrawScreen = WithdrawScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(withdrawScreen.display() instanceof SummaryScreen);
    }

    public void testDisplayWithdraw100d() {
        String input = "3";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WithdrawScreen withdrawScreen = WithdrawScreen.getInstance(scanner,customerMap.get("112233"), customerMap);
        Assert.assertTrue(withdrawScreen.display() instanceof SummaryScreen);
    }

    public void testDisplayOtherWithdrawal() {
        String input = "4";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WithdrawScreen withdrawScreen = WithdrawScreen.getInstance(scanner,customerMap.get("112233"), customerMap);
        Assert.assertTrue(withdrawScreen.display() instanceof OtherWithdrawScreen);
    }

    public void testDisplayTransactionScreen() {
        String input = "5";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WithdrawScreen withdrawScreen = WithdrawScreen.getInstance(scanner,customerMap.get("112233"), customerMap);
        Assert.assertTrue(withdrawScreen.display() instanceof TransactionScreen);
    }

    public void testDisplayOtherInput() {
        String input = "6";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WithdrawScreen withdrawScreen = WithdrawScreen.getInstance(scanner,customerMap.get("112233"), customerMap);
        Assert.assertTrue(withdrawScreen.display() instanceof WithdrawScreen);
    }

    public void testNotSufficientBalance() {
        String input = "3";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WithdrawScreen withdrawScreen = WithdrawScreen.getInstance(scanner,customerMap.get("112244"), customerMap);
        Assert.assertTrue(withdrawScreen.display() instanceof WithdrawScreen);
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
