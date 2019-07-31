package basics.annotation.corejava.v2ch08.set;

import corejava.v2ch08.set.Item;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 1.02 2012-01-26
 * @author Cay Horstmann
 */
public class SetTest
{  
   public static void main(String[] args)
   {  
      Logger.getLogger("com.horstmann").setLevel(Level.FINEST);
      Handler handler = new ConsoleHandler();
      handler.setLevel(Level.FINEST);
      Logger.getLogger("com.horstmann").addHandler(handler);

      Set<corejava.v2ch08.set.Item> parts = new HashSet<>();
      parts.add(new corejava.v2ch08.set.Item("Toaster", 1279));
      parts.add(new corejava.v2ch08.set.Item("Microwave", 4104));
      parts.add(new Item("Toaster", 1279));
      System.out.println(parts);
   }
}
