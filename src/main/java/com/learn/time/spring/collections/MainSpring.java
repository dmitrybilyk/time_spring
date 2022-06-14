package com.learn.time.spring.collections;

import com.learn.time.spring.aspects.SampleAdder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collections/collections.xml");
        JavaCollection jc=(JavaCollection)applicationContext.getBean("javaCollection");

        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();





//        Student student = new Student(new Book("dddd"));
    }
}
