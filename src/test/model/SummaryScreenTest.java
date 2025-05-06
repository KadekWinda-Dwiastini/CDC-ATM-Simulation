package test.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.model.Customer;
import main.model.SummaryScreen;
import main.model.TransactionScreen;
import main.model.WelcomeScreen;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.HashMap;

public class SummaryScreenTest extends TestCase {

    public void testDisplay() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "1";
        provideInput(input);
        SummaryScreen summaryScreen = new SummaryScreen(customerMap.get("112233"), customerMap, 100d, LocalDateTime.now());
        Assert.assertTrue(summaryScreen.display() instanceof TransactionScreen);;
    }

    public void testDisplayExit() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "2";
        provideInput(input);
        SummaryScreen summaryScreen = new SummaryScreen(customerMap.get("112233"), customerMap, 100d, LocalDateTime.now());
        Assert.assertTrue(summaryScreen.display() instanceof WelcomeScreen);;
    }

    public void testDisplayOtherInput() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        String input = "3";
        provideInput(input);
        SummaryScreen summaryScreen = new SummaryScreen(customerMap.get("112233"), customerMap, 100d, LocalDateTime.now());
        Assert.assertTrue(summaryScreen.display() instanceof SummaryScreen);;
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
