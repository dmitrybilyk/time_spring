package com.learn.time.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("my-config.xml");
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student.getName());





//        Student student = new Student(new Book("dddd"));
    }
}
