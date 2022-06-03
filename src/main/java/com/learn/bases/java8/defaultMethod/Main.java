package com.learn.bases.java8.defaultMethod;

//@FunctionalInterface
interface InterfaceDefault {
//    String getString();

    default void defaultMethod(){
        System.out.println("We are default method of interface");
    }

    default void defaultMethod2(){
        defaultMethod();
    }
    public static void staticMethod() {
        System.out.println("additional");
    }
}

class DerivedClass implements InterfaceDefault {
    @Override
    public void defaultMethod() {
        System.out.println("additional");
        InterfaceDefault.staticMethod();
    }

    public void print() {
        InterfaceDefault.staticMethod();
    }
}

class DerivedClass2  {
    public void print() {
        InterfaceDefault.staticMethod();
    }
}

class Main{
    public static void main(String[] args){
        DerivedClass obj1 = new DerivedClass();
        obj1.defaultMethod();
    }
}
