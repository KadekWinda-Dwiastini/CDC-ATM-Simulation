package test.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.model.Customer;
import main.model.OtherWithdrawScreen;
import main.model.SummaryScreen;
import main.model.WithdrawScreen;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

public class OtherWithdrawScreenTest extends TestCase {

    public void testDisplayInsufficientBalance() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "200";
        provideInput(input);
        OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen(customerMap.get("112233"), customerMap);
        Assert.assertTrue(otherWithdrawScreen.display() instanceof WithdrawScreen);
    }

    public void testDisplaySufficientBalance() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "70";
        provideInput(input);
        OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen(customerMap.get("112233"), customerMap);
        Assert.assertTrue(otherWithdrawScreen.display() instanceof SummaryScreen);
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
