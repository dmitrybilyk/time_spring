package com.learn.bases.collections.Map.HashMap;

import java.util.*;
class HashMapDemo 
{

    static class Car implements Cloneable{
        private String name;

        public Car(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Student implements Cloneable {
        private String code;
        private Car car;

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        private String name;
        private int age;

        public Student(String name, int age, String code) {
            this.name = name;
            this.age = age;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Student clone = (Student) super.clone();
            clone.setCar((Car) this.car.clone());
            return clone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return code.equals(student.code);
        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(code);
//        }


        @Override
        public String toString() {
            return name + " " + code;
        }
    }

   public static void main(String args[]) throws CloneNotSupportedException {
       Student student1 = new Student("Dima3", 43, "code1");
       student1.setCar(new Car("Toyota"));
       Student clonedStudent = (Student) student1.clone();
       student1.getCar().setName("T2");
       System.out.println(clonedStudent.getCar().getName());

//       Map<String, List<String>> listMap = new HashMap<>();
//
//       Student student1 = new Student("Dima3", 43, "code1");
//       Student student2 = new Student("Dima5", 42, "code1");
//
////       student2.getClass()
//
//       List<Student> list = new ArrayList<>();
//       list.add(student1);
//       list.add(student2);
//
//       list.remove(student2);
//
//       list.forEach(System.out::println);

//       System.out.println(" by place in memory - " + (student1 == student2));
//       System.out.println(" compare naturally - " + (student1.equals(student2)));

//       student1.equals(student2);


//       Map<Student, Integer> myMap = new HashMap<>();
//       myMap.put(student1, 100);
//       myMap.put(student2, 200);
//
//       for (Student student : myMap.keySet()) {
//           System.out.println(myMap.get(student));
//       }

//       System.out.println(myMap.get(student1));
//
//       Map< String,Integer> hm =
//                        new HashMap< String,Integer>();
//       hm.put("a", new Integer(100));
//       hm.put("b", new Integer(200));
//       hm.put("d", new Integer(400));
//       hm.put("c", new Integer(300));
//
//       // Returns Set view
//       Set< Map.Entry< String,Integer> > st = hm.entrySet();
//
//       for (Map.Entry< String,Integer> me:st)
//       {
//           System.out.print(me.getKey()+":");
//           System.out.println(me.getValue());
//       }
//
//       hm.put("f", new Integer(800));
//
//       st = hm.entrySet();
//       for (Map.Entry< String,Integer> me:st)
//       {
//           System.out.print(me.getKey()+":");
//           System.out.println(me.getValue());
//       }
   } 
} 