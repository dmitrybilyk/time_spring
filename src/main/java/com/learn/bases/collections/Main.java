package com.learn.bases.collections;

//import com.learn.time.model.User;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("two", "one", "al");
//        Iterator it = list.iterator();
//        sortList(list);
////        list.forEach();
////        SomeClass someClass = new SomeClass("d");
//        MyFuncInterface funcInterface = param -> System.out.println(" value - " + param);
//        funcInterfaceUsage(funcInterface, "some value");
//
//        Function<String, Long> function = Long::valueOf;
//        useFunction(function);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        numbers.parallelStream().reduce(Integer::sum).ifPresent(System.out::println);


//        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
//        int computedAges =
//                users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
        List<Integer> users = Arrays.asList(5, 3, 2, 4);
        System.out.println(users.stream().reduce((first, second) -> second));

//        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
//        int result6 = users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
//        System.out.println(result6);

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


