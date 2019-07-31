package basics.annotation.corejava.v2ch08.rect;

import corejava.v2ch08.rect.Rectangle;
import sourceAnnotations.ToStrings;

public class SourceLevelAnnotationDemo
{
   public static void main(String[] args)
   {
      corejava.v2ch08.rect.Rectangle rect = new Rectangle(new Point(10, 10), 20, 30);
      System.out.println(ToStrings.toString(rect));
   }
}
