package test.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.model.Customer;

public class CustomerTest extends TestCase {

    Customer customerJohn = new Customer("John Doe", "012108", "112233",100);
    Customer customerJane = new Customer("Jane Doe", "932012", "112244",30);

    public void testDeductBalance() {
        customerJohn.deductBalance(100d);
        Assert.assertEquals(0d,customerJohn.getBalance());
    }

    public void testAddBalance() {
        customerJane.addBalance(20d);
        Assert.assertEquals(50d, customerJane.getBalance());
    }

    public void testIsLoggedIn() {
        boolean loggedInResult = customerJohn.isLoggedIn("012108");
        Assert.assertTrue(loggedInResult);

        boolean loggInFalseResult = customerJane.isLoggedIn("121212");
        Assert.assertFalse(loggInFalseResult);
    }
}
