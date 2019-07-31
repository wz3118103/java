package basics.oop.corejava.v1ch05.equals;

import corejava.v1ch05.equals.Employee;
import corejava.v1ch05.equals.Manager;

/**
 * This program demonstrates the equals method.
 * @version 1.12 2012-01-26
 * @author Cay Horstmann
 */
public class EqualsTest
{
   public static void main(String[] args)
   {
      corejava.v1ch05.equals.Employee alice1 = new corejava.v1ch05.equals.Employee("Alice Adams", 75000, 1987, 12, 15);
      corejava.v1ch05.equals.Employee alice2 = alice1;
      corejava.v1ch05.equals.Employee alice3 = new corejava.v1ch05.equals.Employee("Alice Adams", 75000, 1987, 12, 15);
      corejava.v1ch05.equals.Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

      System.out.println("alice1 == alice2: " + (alice1 == alice2));

      System.out.println("alice1 == alice3: " + (alice1 == alice3));

      System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

      System.out.println("alice1.equals(bob): " + alice1.equals(bob));

      System.out.println("bob.toString(): " + bob);

      corejava.v1ch05.equals.Manager carl = new corejava.v1ch05.equals.Manager("Carl Cracker", 80000, 1987, 12, 15);
      corejava.v1ch05.equals.Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);
      System.out.println("boss.toString(): " + boss);
      System.out.println("carl.equals(boss): " + carl.equals(boss));
      System.out.println("alice1.hashCode(): " + alice1.hashCode());
      System.out.println("alice3.hashCode(): " + alice3.hashCode());
      System.out.println("bob.hashCode(): " + bob.hashCode());
      System.out.println("carl.hashCode(): " + carl.hashCode());
   }
}