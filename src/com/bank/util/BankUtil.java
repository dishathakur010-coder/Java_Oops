package com.bank.util;
import java.util.Random;
public class BankUtil {
    public static long generateAccountNumber() {
        Random r = new Random();
        long num = 1000000000L + (long)(r.nextDouble() * 9000000000L);
        return num;
    }
    public static void checkMinBalance(double balance) throws Exception {
        if (balance < 1000) {
            throw new Exception("Minimum balance must be ₹1000");
        }
    }
}
