package com.learn.time.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("students name")
    private String name;
    @Autowired
    private Book book;

//    public Student(Book book) {
//        this.book = book;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setBook(Book book) {
        this.book = book;
    }
}
