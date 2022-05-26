package com.learn.time.spring.aspects.account;

public class Account {
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private String accountNumber;
    private double balance;

    // getter / setters / toString
}