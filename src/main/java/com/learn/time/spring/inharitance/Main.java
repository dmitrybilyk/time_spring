package com.learn.time.spring.inharitance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("inheritance/inheritance.xml");
        HelloIndia helloIndia = applicationContext.getBean(HelloIndia.class);
        helloIndia.getMessage1();
        helloIndia.getMessage2();
        helloIndia.getMessage3();
    }
}
