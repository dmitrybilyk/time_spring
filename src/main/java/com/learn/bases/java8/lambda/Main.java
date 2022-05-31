package com.learn.bases.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main  {
    public static void main(String[] args) {
        Consumer<String> myInterface = param -> {
            System.out.println(param);
        };

        boolean decide = true;

        calculate(decide, myInterface, "our param");
    }

    private static void calculate(boolean decide, Consumer<String> myInterface, String our_param) {
        if (decide) {
            myInterface.accept(our_param);
        }
    }
}

@FunctionalInterface
interface MyInterface<T> {
    void doSomething(T param);
}