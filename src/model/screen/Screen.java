package model.screen;

import model.Customer;
import model.Displayable;

import java.util.HashMap;

public abstract class Screen implements Displayable {
    Customer customer;
    HashMap<String, Customer> customerMap;

    public Screen(Customer customer, HashMap<String, Customer> customerMap) {
        this.customer = customer;
        this.customerMap = customerMap;
    }
}
