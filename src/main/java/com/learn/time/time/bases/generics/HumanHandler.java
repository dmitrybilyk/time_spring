package com.learn.time.time.bases.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HumanHandler {
    public void handleHuman(Human human) {
        System.out.println(human);
    }

    public <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }


//    List<Student> could not be put in the place where the List<Human> is expected because java doesn't want
//    to make it possible the object of some other type to be placed in that list. So, List<Human> humans as a parameter
//    is not covariant. To achieve covariance List<? extends Human> should be used.
//    '?' is a wildcard which means 'object of any type'. '? extends Human' - it's an upper bound generic type.
//    '? Super Human' - it's a lower bound generic type.
    public static void printHumans(List<? super Human> humans) {
        humans.forEach(System.out::println);
//        you can't put new Human object to the list which was added as a param with upper bound generic type.
//        Lower bound generic type should be used - '? super Human'
        humans.add(new Human());
    }

    public static void withSuper(List<? super Human> humans) {
//        Human human = humans.get((0)); // not allowed
        humans.add(new Human()); // there is no guarantee here which type you would get from this list.
    }

//    Producer
//    Extends
//    Consumer
//    Super

//    if A is a subtype of B, M<B> is a subtype of M<A>. This is called a contravariance.

    public void test() {
        List<Number> numbers = new ArrayList<>();

//        Reading from the list
        numbers.add(10);
//        Integer integer = numbers.get(0); //we can't read integer as double also could be placed in the numbers list
//        theoretically

    }
}
