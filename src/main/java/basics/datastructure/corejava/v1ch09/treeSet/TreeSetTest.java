package basics.datastructure.corejava.v1ch09.treeSet;

import corejava.v1ch09.treeSet.Item;

import java.util.*;

/**
 * This program sorts a set of item by comparing their descriptions.
 * @version 1.12 2015-06-21
 * @author Cay Horstmann
 */
public class TreeSetTest
{
   public static void main(String[] args)
   {
      SortedSet<corejava.v1ch09.treeSet.Item> parts = new TreeSet<>();
      parts.add(new corejava.v1ch09.treeSet.Item("Toaster", 1234));
      parts.add(new corejava.v1ch09.treeSet.Item("Widget", 4562));
      parts.add(new corejava.v1ch09.treeSet.Item("Modem", 9912));
      System.out.println(parts);

      NavigableSet<corejava.v1ch09.treeSet.Item> sortByDescription = new TreeSet<>(
            Comparator.comparing(Item::getDescription));

      sortByDescription.addAll(parts);
      System.out.println(sortByDescription);
   }
}