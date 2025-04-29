package model.screen;

import model.Customer;
import model.Displayable;

public abstract class Screen implements Displayable {
    Customer customer;

    public Screen(Customer customer) {
        this.customer = customer;
    }
}
