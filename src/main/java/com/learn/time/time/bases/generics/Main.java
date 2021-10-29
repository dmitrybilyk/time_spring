package com.learn.time.time.bases.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
//        humanList = new ArrayList<Student>();
        HumanHandler humanHandler = new HumanHandler();
        Human human = new Human();
        Student student = new Student();
        Human humanStudent = new Student();
//        humanHandler.handleHuman(humanStudent);

        Human[] humansArray = {human, humanStudent};
//        System.out.println(humanHandler.fromArrayToList(humansArray));
//
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println(HumanHandler.fromArrayToList(intArray, Object::hashCode));

        HumanHandler.printHumans(humanList);

        List<Human> students = List.of(human);
        HumanHandler.printHumans(students);

        HumanHandler.withSuper(new ArrayList<Object>());
    }
}
