package library.io.corejava.v2ch02.objectStream;

import corejava.v2ch02.objectStream.Employee;
import corejava.v2ch02.objectStream.Manager;

import java.io.*;

/**
 * @version 1.10 17 Aug 1998
 * @author Cay Horstmann
 */
class ObjectStreamTest
{
   public static void main(String[] args) throws IOException, ClassNotFoundException
   {
      corejava.v2ch02.objectStream.Employee harry = new corejava.v2ch02.objectStream.Employee("Harry Hacker", 50000, 1989, 10, 1);
      corejava.v2ch02.objectStream.Manager carl = new corejava.v2ch02.objectStream.Manager("Carl Cracker", 80000, 1987, 12, 15);
      carl.setSecretary(harry);
      corejava.v2ch02.objectStream.Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
      tony.setSecretary(harry);

      corejava.v2ch02.objectStream.Employee[] staff = new corejava.v2ch02.objectStream.Employee[3];

      staff[0] = carl;
      staff[1] = harry;
      staff[2] = tony;

      // save all employee records to the file employee.dat         
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) 
      {
         out.writeObject(staff);
      }

      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat")))
      {
         // retrieve all records into a new array
         
         corejava.v2ch02.objectStream.Employee[] newStaff = (corejava.v2ch02.objectStream.Employee[]) in.readObject();

         // raise secretary's salary
         newStaff[1].raiseSalary(10);

         // print the newly read employee records
         for (Employee e : newStaff)
            System.out.println(e);
      }
   }
}