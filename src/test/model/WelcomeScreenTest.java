package test.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.model.Customer;
import main.model.TransactionScreen;
import main.model.WelcomeScreen;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

public class WelcomeScreenTest extends TestCase {


    public void testDisplaySuccess() {
        String input = "112233\n012108";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WelcomeScreen welcomeScreen = new WelcomeScreen(null, customerMap);
        Assert.assertTrue(welcomeScreen.display() instanceof TransactionScreen);
    }

    public void testDisplayInvalidAccountNum() {
        String input = "1122";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WelcomeScreen welcomeScreen = new WelcomeScreen(null, customerMap);
        Assert.assertTrue(welcomeScreen.display() instanceof WelcomeScreen);
    }

    public void testDisplayInvalidPin() {
        String input = "112233\n1sa";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WelcomeScreen welcomeScreen = new WelcomeScreen(null, customerMap);
        Assert.assertTrue(welcomeScreen.display() instanceof WelcomeScreen);
    }

    public void testDisplayInputContainsNonNumber() {
        String input = "112233\npasswr";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WelcomeScreen welcomeScreen = new WelcomeScreen(null, customerMap);
        Assert.assertTrue(welcomeScreen.display() instanceof WelcomeScreen);
    }

    public void testDisplayInvalidAccount() {
        String input = "112233\n111111";
        provideInput(input);
        HashMap<String, Customer> customerMap = getCustomerMap();
        WelcomeScreen welcomeScreen = new WelcomeScreen(null, customerMap);
        Assert.assertTrue(welcomeScreen.display() instanceof WelcomeScreen);
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