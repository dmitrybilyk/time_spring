package com.learn.time.spring.aspects;

import com.learn.time.spring.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/aop.xml");
        SampleAdder adder = applicationContext.getBean(SampleAdder.class);
        adder.add(3, 6);





//        Student student = new Student(new Book("dddd"));
    }
}
