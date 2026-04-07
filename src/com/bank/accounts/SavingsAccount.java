package com.bank.accounts;
public class SavingsAccount extends Account {
    double interestRate;
    public SavingsAccount(long accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public double calculateInterest() {
        double interest = (balance * interestRate) / 100;
        return interest;
    }
}
