package basics.nativemethod.corejava.v2ch12.printf1;

import corejava.v2ch12.printf1.Printf1;

/**
 * @version 1.10 1997-07-01
 * @author Cay Horstmann
 */
class Printf1Test
{
   public static void main(String[] args)
   {
      int count = corejava.v2ch12.printf1.Printf1.print(8, 4, 3.14);
      count += corejava.v2ch12.printf1.Printf1.print(8, 4, count);
      System.out.println();
      for (int i = 0; i < count; i++)
         System.out.print("-");
      System.out.println();
   }
}
