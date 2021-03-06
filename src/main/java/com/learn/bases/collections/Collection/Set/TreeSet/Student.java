package com.learn.bases.collections.Collection.Set.TreeSet;

/**
 * Created by bid on 8/21/14.
 */
public class Student implements Comparable<Student>
{
   private String name;

   public String getName()
   {
      return name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   @Override
   public int compareTo(Student o) {
      return this.getName().compareTo(o.getName());
   }

//   @Override
//   public int compareTo(final Object o)
//   {
//      Student other = (Student) o;
//      return this.name.compareTo(other.getName());
//   }
}
