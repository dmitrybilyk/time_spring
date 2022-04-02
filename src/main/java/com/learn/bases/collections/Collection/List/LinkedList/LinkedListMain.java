package com.learn.bases.collections.Collection.List.LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bid on 8/21/14.
 */

// LinkedList inside is just a several elements - Nodes, which have pointers to the next and previous elements.
//   It's quick to add and remove to/from the first/last position. The closer to the edges the better
public class LinkedListMain
{
   public static void main(String[] args)
   {
      List<String> list = new LinkedList<String>();
      list.add("0");
      list.add("1");
      list.add("2");
      list.add("3");
      list.add("4");
      list.add("5");
      list.add("6");
      list.add("7");

      list.remove(3);

      list.forEach(System.out::println);




   }

}
