package test.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.model.*;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class FundTransferSummaryScreenTest extends TestCase {
    Scanner scanner = new Scanner(System.in);

    public void testDisplayTransaction() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "1";
        provideInput(input);
        FundTransferSummaryScreen fundTransferSummaryScreen = FundTransferSummaryScreen.getInstance(scanner, customerMap.get("112233"), customerMap, "112244", 50d, "123456");
        Assert.assertTrue(fundTransferSummaryScreen.display() instanceof TransactionScreen);
    }

    public void testDisplayExit() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "2";
        provideInput(input);
        FundTransferSummaryScreen fundTransferSummaryScreen = FundTransferSummaryScreen.getInstance(scanner, customerMap.get("112233"), customerMap, "112244", 50d, "123456");
        Assert.assertTrue(fundTransferSummaryScreen.display() instanceof WelcomeScreen);
    }

    public void testDisplayOthers() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "10";
        provideInput(input);
        FundTransferSummaryScreen fundTransferSummaryScreen = FundTransferSummaryScreen.getInstance(scanner, customerMap.get("112233"), customerMap, "112244", 50d, "123456");
        Assert.assertTrue(fundTransferSummaryScreen.display() instanceof FundTransferSummaryScreen);
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
