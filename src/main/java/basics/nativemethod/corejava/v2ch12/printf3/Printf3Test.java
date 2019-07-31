package basics.nativemethod.corejava.v2ch12.printf3;

import corejava.v2ch12.printf3.Printf3;

import java.io.*;

/**
 * @version 1.10 1997-07-01
 * @author Cay Horstmann
 */
class Printf3Test
{
   public static void main(String[] args)
   {
      double price = 44.95;
      double tax = 7.75;
      double amountDue = price * (1 + tax / 100);
      PrintWriter out = new PrintWriter(System.out);
      corejava.v2ch12.printf3.Printf3.fprint(out, "Amount due = %8.2f\n", amountDue);
      out.flush();
   }
}
