package com.learn.time.time.bases.generics.covar_and_contrvar;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Fruit> fruits = new ArrayList<>();
        ArrayList<Orange> oranges = new ArrayList<>();

//        fruits = oranges;

        fruits.add(new Orange());
//        oranges.add(new Fruit());

        Fruit fruit = oranges.get(0);
//        Orange orange = fruits.get(0);

//        Fruit fruit = new Fruit();
//        Citrus citrus = new Citrus();
//        Orange orange = new Orange();

//        citrus = orange;

//        ArrayList<Citrus> citruses = new ArrayList<>();
//        ArrayList<Orange> oranges = new ArrayList<>();
//        totalWeight(oranges);
//        Fruit fruit1 = oranges.get(0);

//        addOrange(citruses);
    }

    private static int totalWeight(ArrayList<? extends Citrus> citruses) {
        int weight = 0;
        for ( int i = 0; i < citruses.size(); i++ ) {
            weight += citruses.get(i).weight;
        }
//        citruses.add(new Citrus());
        return weight;
    }

    private static void addOrange(ArrayList<? super Orange> oranges) {
        for (int i = 0; i < 10; i++) {
            oranges.add(new Orange());
        }
    }

    static class Fruit {
        int weight;
    }

    static class Citrus extends Fruit {
        int weight;
    }

    static class Orange extends Citrus {
        int color;
    }

    static class BigRoundOrange extends Orange {
        int size = 100;
    }
}
