package basics.annotation.corejava.v2ch08.bytecodeAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.00 2004-08-17
 * @author Cay Horstmann
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogEntry
{
   String logger();
}
