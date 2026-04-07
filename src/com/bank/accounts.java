package com.bank.accounts;
import com.bank.exceptions.InsufficientBalanceException;
public class Account {
    public long accountNumber;
    public double balance;
    double minBalance = 1000;
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        if (balance - amount < minBalance) {
            throw new InsufficientBalanceException("Minimum balance must be ₹1000");
        }
        balance = balance - amount;
        System.out.println("Withdrawn: " + amount);
    }
    public double getBalance() {
        return balance;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
}
