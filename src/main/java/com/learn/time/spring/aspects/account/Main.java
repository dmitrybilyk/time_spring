package com.learn.time.spring.aspects.account;

import com.learn.time.spring.aspects.annotations.MainAop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/aop-account.xml");
        BankAccountService mainAop = applicationContext.getBean(BankAccountService.class);
        Account account = new Account();
        account.setBalance(2000d);
        account.setAccountNumber("454545");
        mainAop.deposit(account, 1000d);
    }

}
