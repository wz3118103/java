package library.io.corejava.v2ch02.randomAccess;

import corejava.v2ch02.randomAccess.DataIO;
import corejava.v2ch02.randomAccess.Employee;

import java.io.*;
import java.util.*;
import java.time.*;

/**
 * @version 1.13 2016-07-11
 * @author Cay Horstmann
 */
public class RandomAccessTest
{  
   public static void main(String[] args) throws IOException
   {
      corejava.v2ch02.randomAccess.Employee[] staff = new corejava.v2ch02.randomAccess.Employee[3];

      staff[0] = new corejava.v2ch02.randomAccess.Employee("Carl Cracker", 75000, 1987, 12, 15);
      staff[1] = new corejava.v2ch02.randomAccess.Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new corejava.v2ch02.randomAccess.Employee("Tony Tester", 40000, 1990, 3, 15);

      try (DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat")))
      {  
         // save all employee records to the file employee.dat
         for (corejava.v2ch02.randomAccess.Employee e : staff)
            writeData(out, e);
      }
         
      try (RandomAccessFile in = new RandomAccessFile("employee.dat", "r"))
      {
         // retrieve all records into a new array
            
         // compute the array size
         int n = (int)(in.length() / corejava.v2ch02.randomAccess.Employee.RECORD_SIZE);
         corejava.v2ch02.randomAccess.Employee[] newStaff = new corejava.v2ch02.randomAccess.Employee[n];

         // read employees in reverse order
         for (int i = n - 1; i >= 0; i--)
         {  
            newStaff[i] = new corejava.v2ch02.randomAccess.Employee();
            in.seek(i * corejava.v2ch02.randomAccess.Employee.RECORD_SIZE);
            newStaff[i] = readData(in);
         }
         
         // print the newly read employee records
         for (corejava.v2ch02.randomAccess.Employee e : newStaff)
            System.out.println(e);
      }
   }

   /**
    * Writes employee data to a data output
    * @param out the data output
    * @param e the employee
    */
   public static void writeData(DataOutput out, corejava.v2ch02.randomAccess.Employee e) throws IOException
   {
      corejava.v2ch02.randomAccess.DataIO.writeFixedString(e.getName(), corejava.v2ch02.randomAccess.Employee.NAME_SIZE, out);
      out.writeDouble(e.getSalary());

      LocalDate hireDay = e.getHireDay();
      out.writeInt(hireDay.getYear());
      out.writeInt(hireDay.getMonthValue());
      out.writeInt(hireDay.getDayOfMonth());
   }

   /**
    * Reads employee data from a data input
    * @param in the data input
    * @return the employee
    */
   public static corejava.v2ch02.randomAccess.Employee readData(DataInput in) throws IOException
   {      
      String name = DataIO.readFixedString(corejava.v2ch02.randomAccess.Employee.NAME_SIZE, in);
      double salary = in.readDouble();
      int y = in.readInt();
      int m = in.readInt();
      int d = in.readInt();
      return new Employee(name, salary, y, m - 1, d);
   }  
}
