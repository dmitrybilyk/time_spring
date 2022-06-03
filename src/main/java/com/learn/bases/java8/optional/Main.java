package com.learn.bases.java8.optional;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Main {
    static Consumer<String> consumer = s -> System.out.println(s);

    static Consumer<String> newConsumer = s -> System.out.println(s);

    public static void main(String[] args) {
        String nullName = "Petya";

        newConsumer.accept("dfdf");

//        String nullName = null;

        Optional<String> name = Optional.ofNullable(nullName);

        name.ifPresent(s -> System.out.println(s));
//        System.out.println(name.get());

        List<String> list = new ArrayList<>();

//        SomeClass someClass = new SomeClass();

        list.forEach(SomeClass::new);



        consumer.accept("our param");


//        name.ifPresent(s -> System.out.println(s));
//                .orElseThrow(NullPointerException::new);
        // .orElseThrow(CustomException::new);
    }

    static void someMethod(String string) {
        System.out.println("somethign to do");
    }

}

class SomeClass {
    private String field;

    public SomeClass(String field) {
        this.field = field;
    }

    void someMethod2(String string) {
        System.out.println("somethign to do");
    }
}
