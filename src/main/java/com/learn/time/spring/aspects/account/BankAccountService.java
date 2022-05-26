package com.learn.time.spring.aspects.account;

import org.springframework.stereotype.Component;

@Component
public class BankAccountService {
    private String someField;

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }

    @AccountOperation(operation = "deposit")
    public void deposit(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    @AccountOperation(operation = "withdraw")
    public void withdraw(Account account, Double amount) throws Exception {

        if(amount > 500.0) {
            throw new Exception("Withdraw limit exceeded.");
        }

        account.setBalance(account.getBalance() - amount);
    }

    public double getBalance() {
        return 5000;
    }
}