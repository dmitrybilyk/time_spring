package com.learn.time.spring.lifecycle;

import com.learn.time.spring.aspects.SampleAdder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lifecycle/lifecycle.xml");
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student.getName());
    }
}
