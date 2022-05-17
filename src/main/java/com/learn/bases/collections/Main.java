package com.learn.bases.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("two", "one", "al");
        sortList(list);
//        list.forEach();
//        SomeClass someClass = new SomeClass("d");
        MyFuncInterface funcInterface = param -> System.out.println(" value - " + param);
        funcInterfaceUsage(funcInterface, "some value");

        Function<String, Long> function = Long::valueOf;
        useFunction(function);

    }

    public static void println(String x) {
        System.out.println(x);
    }

    public static void useFunction(Function<String, Long> function) {
        function.apply("30");
    }

    public static void funcInterfaceUsage(MyFuncInterface myFuncInterface, String param) {
        int i = 20;
        if (i > 10) {
            myFuncInterface.print(param);
        } else {
            myFuncInterface.print(param);
            myFuncInterface.print(param);
        }

    }

    private static List<String> sortList(List<String> list) {
        final int i = 10;
//        i = 20;
        Collections.sort(list, (o1, o2) -> {
            System.out.println(i);
            return o2.compareTo(o1);
        });
        return list;
    }
}

class SomeClass {
    private String s;

    public SomeClass(String s) {
        this.s = s;
    }

    public void println777(String x) {
        System.out.println(x);
    }
}

@FunctionalInterface
interface MyFuncInterface {
    void print(String param);
//    void print2(String param);
}

class LambdaUser {
    private int i;
    private static int a;
    void print() {
//        int a;
        Comparator<String> comparator =
                (o1, o2) -> {
            i = 20;
            int a = 40;
                    return 0;
                }
                    ;
                }
    }


