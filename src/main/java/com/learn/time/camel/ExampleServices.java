package com.learn.time.camel;

public class ExampleServices {
    public static void example(MyBean bodyIn) {
        bodyIn.setName( "Hello, " + bodyIn.getName() );
        bodyIn.setId(bodyIn.getId() * 10);
    }
}