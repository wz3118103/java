package basics.generics.corejava.v1ch08.pair3;

import corejava.v1ch08.pair3.Employee;
import corejava.v1ch08.pair3.Manager;
import corejava.v1ch08.pair3.Pair;

/**
 * @version 1.01 2012-01-26
 * @author Cay Horstmann
 */
public class PairTest3
{
   public static void main(String[] args)
   {
      corejava.v1ch08.pair3.Manager ceo = new corejava.v1ch08.pair3.Manager("Gus Greedy", 800000, 2003, 12, 15);
      corejava.v1ch08.pair3.Manager cfo = new corejava.v1ch08.pair3.Manager("Sid Sneaky", 600000, 2003, 12, 15);
      corejava.v1ch08.pair3.Pair<corejava.v1ch08.pair3.Manager> buddies = new corejava.v1ch08.pair3.Pair<>(ceo, cfo);
      printBuddies(buddies);

      ceo.setBonus(1000000);
      cfo.setBonus(500000);
      corejava.v1ch08.pair3.Manager[] managers = { ceo, cfo };

      corejava.v1ch08.pair3.Pair<corejava.v1ch08.pair3.Employee> result = new corejava.v1ch08.pair3.Pair<>();
      minmaxBonus(managers, result);
      System.out.println("first: " + result.getFirst().getName() 
         + ", second: " + result.getSecond().getName());
      maxminBonus(managers, result);
      System.out.println("first: " + result.getFirst().getName() 
         + ", second: " + result.getSecond().getName());
   }

   public static void printBuddies(corejava.v1ch08.pair3.Pair<? extends corejava.v1ch08.pair3.Employee> p)
   {
      corejava.v1ch08.pair3.Employee first = p.getFirst();
      Employee second = p.getSecond();
      System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
   }

   public static void minmaxBonus(corejava.v1ch08.pair3.Manager[] a, corejava.v1ch08.pair3.Pair<? super corejava.v1ch08.pair3.Manager> result)
   {
      if (a.length == 0) return;
      corejava.v1ch08.pair3.Manager min = a[0];
      corejava.v1ch08.pair3.Manager max = a[0];
      for (int i = 1; i < a.length; i++)
      {
         if (min.getBonus() > a[i].getBonus()) min = a[i];
         if (max.getBonus() < a[i].getBonus()) max = a[i];
      }
      result.setFirst(min);
      result.setSecond(max);
   }

   public static void maxminBonus(corejava.v1ch08.pair3.Manager[] a, corejava.v1ch08.pair3.Pair<? super Manager> result)
   {
      minmaxBonus(a, result);
      PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
   }
   // Can't write public static <T super manager> ...
}

class PairAlg
{
   public static boolean hasNulls(corejava.v1ch08.pair3.Pair<?> p)
   {
      return p.getFirst() == null || p.getSecond() == null;
   }

   public static void swap(corejava.v1ch08.pair3.Pair<?> p) { swapHelper(p); }

   public static <T> void swapHelper(Pair<T> p)
   {
      T t = p.getFirst();
      p.setFirst(p.getSecond());
      p.setSecond(t);
   }
}


