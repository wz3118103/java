package basics.nativemethod.corejava.v2ch12.printf2;

import corejava.v2ch12.printf2.Printf2;

/**
 * @version 1.10 1997-07-01
 * @author Cay Horstmann
 */
class Printf2Test
{
   public static void main(String[] args)
   {
      double price = 44.95;
      double tax = 7.75;
      double amountDue = price * (1 + tax / 100);

      String s = corejava.v2ch12.printf2.Printf2.sprint("Amount due = %8.2f", amountDue);
      System.out.println(s);
   }
}
