package com.learn.time.spring;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private String title;

//    public Book(String someTitle) {
//        this.title = someTitle;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
