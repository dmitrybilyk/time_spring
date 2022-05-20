package com.learn.time.spring.aspects.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/aop.xml");
        MainAop mainAop = applicationContext.getBean(MainAop.class);
        mainAop.serve();
        mainAop.serve2();
    }

}
