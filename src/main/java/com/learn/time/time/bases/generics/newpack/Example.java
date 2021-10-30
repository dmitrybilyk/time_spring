package com.learn.time.time.bases.generics.newpack;

import java.util.*;

public class Example {

    static void doesntCompile(Map<Integer, List<? extends Number>> map) {
        List<Double> list = new ArrayList<>();
        list.add(0.);
        map.put(0, list);
    }
    static <T extends Number> void compiles(Map<Integer, List<T>> map) {
        List<Double> list = new ArrayList<>();
        list.add(10.);
//        map.put(10, list); // does not compile
    }

    static void function(List<? extends Number> outer)
    {
//        doesntCompile(new HashMap<Integer, List<Integer>>());
        compiles(new HashMap<Integer, List<Integer>>());
    }

//    public <T> void underLimit(List<T> myList, T limit) {
//        for (T e : myList) {
//            if (e < limit) // can't user < with generic types
//                System.out.println(e);
//        }
//    }

    public <T extends Comparable<T>> void underLimit(
            List<T> myList, T limit) {
        for (T e : myList) {
            if (e.compareTo(limit) < 0)
                System.out.println(e);
        }
    }

    public static void meth1(List<Person> list) {
//        if (list instanceof List<Person>) { Illegal generic type for instanceof
            List<Person> pl = (List<Person>) list;


        List<Student> sl = new ArrayList<Student>();
        List<Faculty> fl = new ArrayList<Faculty>();
//        if (sl.getClass() == fl.getClass()){  //always true > Type Erasure

//        }
    }
}


class MyClass<T> {
//    private static T value; // error 'com.learn.time.time.bases.generics.newpack.MyClass.this' cannot be referenced from a static contex
//      ...
}