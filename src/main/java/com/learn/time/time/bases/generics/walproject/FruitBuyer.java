package com.learn.time.time.bases.generics.walproject;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FruitBuyer {
    public static void main(String[] args) {
        FruitBuyer fruitBuyer = new FruitBuyer();
        List<Fruit> fruitList = new ArrayList<>();
        Buyer fruitsBuyer = new Buyer("Fruits buyer 1");
        buyingList(fruitList, fruitsBuyer); //OK

        List<Apple> applesList = new ArrayList<>();
        Buyer applesBuyer = new Buyer("Apples buyer 1");
        buyingList(applesList, applesBuyer); //Not OK. If parameter is declared as List<Fruit then List<Apple> could
//                                                not be applied as List<Apple> is not covariant of List<Fruit> (this is 'invariance').
//                                                It's like this because java wants to avoid adding Strawberry to the list
//                                                  of Apples. <? extends Fruit> fixes compilation error (this becomes 'covariance')

//        Contravariance is the situation when reference of type List<Fruit> could have an object of type List<Apple>
//        assigned on it
//        List<Fruit> fruitList1 = new ArrayList<Apple>();


    }

    public static Fruit buyFruit(Fruit fruit) {
        return FruitBuyer.buyingOne(fruit);
    }

    private static Fruit buyingOne(Fruit fruit) {
        log.info("The fruit {} is bought", fruit.getName());
        fruit.setBought(true);
        return fruit;
    }

    private static Buyer buyingList(List<? extends Fruit> fruitList, Buyer buyer) {
        log.info("The fruits {} are bought", String.join(fruitList.stream().map(Fruit::getName).collect(Collectors.joining())));
        fruitList.forEach(fruit -> fruit.setBought(true));
        log.info("The buyer of the list is {}", buyer.getName());
        return buyer;
    }

}
