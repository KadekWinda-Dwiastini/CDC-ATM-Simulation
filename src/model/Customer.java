package model;

public class Customer {
    private String name;
    private String pin;
    private String accountNumber;
    private double balance; //in dollar $

    public Customer(String name, String pin, String accountNumber, double balance) {
        this.name = name;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deductBalance(Double withdrawalAmt) {
        this.balance = this.balance-withdrawalAmt;
    }

    public boolean isLoggedIn(String pin, String inputtedPin) {
        if (pin.equals(inputtedPin)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
