package basics.nativemethod.corejava.v2ch12.employee;

import corejava.v2ch12.employee.Employee;

/**
 * @version 1.10 1999-11-13
 * @author Cay Horstmann
 */

public class EmployeeTest
{
   public static void main(String[] args)
   {
      corejava.v2ch12.employee.Employee[] staff = new corejava.v2ch12.employee.Employee[3];

      staff[0] = new corejava.v2ch12.employee.Employee("Harry Hacker", 35000);
      staff[1] = new corejava.v2ch12.employee.Employee("Carl Cracker", 75000);
      staff[2] = new corejava.v2ch12.employee.Employee("Tony Tester", 38000);

      for (corejava.v2ch12.employee.Employee e : staff)
         e.raiseSalary(5);
      for (Employee e : staff)
         e.print();
   }
}
