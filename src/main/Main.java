package main;

import main.model.Customer;
import main.model.Displayable;
import main.model.WelcomeScreen;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Customer> customerMapData = initializeData();
        Displayable displayedScreen = new WelcomeScreen(customerMapData);
        while (displayedScreen != null) {
            displayedScreen = displayedScreen.display();
        }
    }

    private static HashMap<String, Customer> initializeData() {
        HashMap<String, Customer> customerListMap = new HashMap<>();
        customerListMap.put("112233", new Customer("John Doe", "012108", "112233",100));
        customerListMap.put("112244", new Customer("Jane Doe", "932012", "112244",30));
        return customerListMap;
    }
}