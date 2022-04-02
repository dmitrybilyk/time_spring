package com.learn.bases.collections.Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

//ArrayList is backed by the array. All 'change' operations require indexes re-calculations and sometimes backed array
//re-creation. ArrayList is effective when we do operations with indexes or when we do something at the end of it
public class ArrayListMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("The last");

        list.remove(1);

        list.forEach(System.out::println);
    }
}
