package basics.oop.corejava.v1ch05.inheritance;

import corejava.v1ch05.inheritance.Employee;
import corejava.v1ch05.inheritance.Manager;

/**
 * This program demonstrates inheritance.
 * @version 1.21 2004-02-21
 * @author Cay Horstmann
 */
public class ManagerTest
{
   public static void main(String[] args)
   {
      // construct a Manager object
      corejava.v1ch05.inheritance.Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);

      corejava.v1ch05.inheritance.Employee[] staff = new corejava.v1ch05.inheritance.Employee[3];

      // fill the staff array with Manager and Employee objects

      staff[0] = boss;
      staff[1] = new corejava.v1ch05.inheritance.Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new corejava.v1ch05.inheritance.Employee("Tommy Tester", 40000, 1990, 3, 15);

      // print out information about all Employee objects
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
   }
}