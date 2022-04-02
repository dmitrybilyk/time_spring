package com.learn.bases.generics.newpack;

import java.util.Collections;
import java.util.List;

public class GenericContainer<T> {

    public static void main(String[] args) {
//        List<Bike> bikes = Collections.singletonList(new Bike());
        List<Student> students = Collections.singletonList(new Student());
        printList(students);
    }

    private static void printList(List<? extends Person> list) {

    }

}

class Person {

}

class Student extends Person {

}

class Faculty extends Person {

}

class Bike {

}