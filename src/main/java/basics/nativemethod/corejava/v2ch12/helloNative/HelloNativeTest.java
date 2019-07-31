package basics.nativemethod.corejava.v2ch12.helloNative;

import corejava.v2ch12.helloNative.HelloNative;

/**
 *  @version 1.11 2007-10-26
 *  @author Cay Horstmann
 */
class HelloNativeTest
{  
   public static void main(String[] args)
   {  
      corejava.v2ch12.helloNative.HelloNative.greeting();
   }

   static
   {  
      System.loadLibrary("HelloNative");
   }
}
