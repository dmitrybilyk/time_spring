package com.learn.time.camel.myrest;

import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {
    public ResponseType sayHello() {
        return new ResponseType("Hello, world!");
    }
}