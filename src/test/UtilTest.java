package test;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.Util;
import main.model.Customer;

import java.time.LocalDateTime;
import java.util.HashMap;

public class UtilTest extends TestCase {
    String onlyNumber = "201293";

    private static HashMap<String, Customer> getCustomerMap() {
        HashMap<String, Customer> customerListMap = new HashMap<>();
        customerListMap.put("112233", new Customer("John Doe", "012108", "112233",100));
        customerListMap.put("112244", new Customer("Jane Doe", "932012", "112244",30));
        return customerListMap;
    }

    public void testOnlyContainsNumber() {
        boolean trueTCResult = Util.onlyContainsNumber(onlyNumber);
        Assert.assertTrue(trueTCResult);

        String notOnlyNumber = "as1293+";
        boolean falseTCResult = Util.onlyContainsNumber(notOnlyNumber);
        Assert.assertFalse(falseTCResult);
    }

    public void testValidateDigitLength() {
        boolean trueTCResult = Util.validateDigitLength(6, onlyNumber);
        Assert.assertTrue(trueTCResult);

        boolean falseTCResult = Util.validateDigitLength(7, onlyNumber);
        Assert.assertFalse(falseTCResult);
    }

    public void testValidWithdrawalAmt() {
        boolean trueTCResult = Util.validWithdrawalAmt("10", 100d);
        Assert.assertTrue(trueTCResult);

        boolean notOnlyContainsNumberTCResult = Util.validWithdrawalAmt("10aa", 100d);
        Assert.assertFalse(notOnlyContainsNumberTCResult);

        boolean notValidNumberTCResult = Util.validWithdrawalAmt("4", 100d);
        Assert.assertFalse(notValidNumberTCResult);

        boolean moreThanMaxAmountTCResult = Util.validWithdrawalAmt("1500", 100d);
        Assert.assertFalse(moreThanMaxAmountTCResult);
    }

    public void testIsSufficientBalance() {
        boolean trueTCResult = Util.isSufficientBalance(100, 10);
        Assert.assertTrue(trueTCResult);

        boolean falseTCResult = Util.isSufficientBalance(100, 150);
        Assert.assertFalse(falseTCResult);
    }

    public void testGetFormattedDateTime() {
        String formattedDateTime = Util.getFormattedDateTime(LocalDateTime.parse("2015-08-04T10:11:30"));
        Assert.assertEquals("2015-08-04 10:11:30 AM", formattedDateTime);
    }

    public void testAccountNumberExisted() {
        HashMap<String, Customer> customerMap = getCustomerMap();
        boolean trueTCResult = Util.accountNumberExisted(customerMap, "112233");
        Assert.assertTrue(trueTCResult);

        boolean falseTCResult = Util.accountNumberExisted(customerMap, "111111");
        Assert.assertFalse(falseTCResult);
    }

    public void testGetRandomStringNumber() {
        String randomStringNumber = Util.getRandomStringNumber();
        Assert.assertEquals(6, randomStringNumber.length());
        Assert.assertTrue(Util.onlyContainsNumber(randomStringNumber));

    }
}
