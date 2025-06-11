package test.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.model.Customer;
import main.model.FundTransferScreen;
import main.model.FundTransferSummaryScreen;
import main.model.TransactionScreen;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class FundTransferScreenTest extends TestCase {
    Scanner scanner = new Scanner(System.in);

    public void testDisplayEsc() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "Esc";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay2Esc() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112233\nEsc";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay3Esc() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112233\n100\nEsc";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay3Others() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112233\n100\n11";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof FundTransferScreen);
    }

    public void testDisplay4() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112233\n100\n\n\n2";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay4OthersInput() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112233\n100\n\n\n3";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof FundTransferScreen);
    }

    public void testDisplay4InvalidAccount() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112266\n100\n\n\n1";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay4InvalidAmount() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112244\nasa\n\n\n1";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay4MaxAmount() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112244\n2000\n\n\n1";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay4MinAmount() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112244\n0\n\n\n1";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay4InsufficientBalance() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112244\n200\n\n\n1";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof TransactionScreen);
    }

    public void testDisplay4SufficientBalance() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "112244\n80\n\n\n1";
        provideInput(input);
        FundTransferScreen fundTransferScreen = FundTransferScreen.getInstance(scanner, customerMap.get("112233"), customerMap);
        Assert.assertTrue(fundTransferScreen.display() instanceof FundTransferSummaryScreen);
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
