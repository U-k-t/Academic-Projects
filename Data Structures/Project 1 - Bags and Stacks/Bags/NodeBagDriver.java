import java.util.Scanner;

public class NodeBagDriver
{
   private static boolean cont = true;
   public static void main (String[] args)
   {
      Scanner kb = new Scanner(System.in);
      NodeBag classroom = new NodeBag();
      classroom.add(new Student(12345,"Pam","Gold","Senior"));
      classroom.add(new Student(54321,"Mike","Gold","Senior"));
      classroom.add(new Student(67890,"Dan","Gold","Senior"));
      classroom.add(new Student(99999,"Jacob","Gold","Senior"));
      classroom.add(new Student(10918,"Diana","Gold","Senior"));
      while (cont)
      {
         System.out.println ("Press 'A' to add a student to the class");
         System.out.println ("Press 'R' to remove a student from the class");
         System.out.println ("Press 'S' to search for a student in the class");
         System.out.println ("Press 'F' to count the number of students in a particular standing");
         System.out.println ("Press 'D' to view the total enrollment count");
         System.out.println ("Press 'W' to view if the class is Empty");
         System.out.println ("Press 'E' to exit");
         String input = kb.nextLine().toUpperCase();
         if(input.charAt(0) == 'A')
         {
            Student temp = new Student ();
            System.out.print("Enter Student idNum:  ");
            int number = kb.nextInt();
            kb.nextLine();
            temp.setID(number);
            System.out.print("Enter Student First Name:  ");
            String name = kb.nextLine();
            temp.setFirst(name);
            System.out.print("Enter Student Last Name:  ");
            String last = kb.nextLine();
            temp.setLast(last);
            System.out.print("Enter Student Grade Level:  ");
            String standing = kb.nextLine();
            temp.setStanding(standing);
            if(classroom.containsObject(number))
               throw new IllegalStateException("Classroom already contains student"+
                                             "with ID" + number);
            else
               classroom.add(temp);
         }
         else if(input.charAt(0) == 'R')
         {
            System.out.print("Input Student ID to Remove:  ");
            System.out.println(classroom.remove(kb.nextInt()));
            kb.nextLine();
         }
         else if (input.charAt(0) == 'S')
         {
            System.out.print("Input Student ID to Search:  ");
            int tempID = kb.nextInt();
            boolean isStudent = classroom.containsObject(tempID);
            kb.nextLine();
            if(isStudent)
               System.out.println("Student ID: " + tempID + " is a member of the class");
            else
               System.out.println("Student ID: " + tempID + " is not a member of the class");
         }
         else if (input.charAt(0) == 'E')
            System.exit(0);
         else if (input.charAt(0) == 'F')
         {
            System.out.print("Input Student Standing to Count: ");
            String standing = kb.nextLine();
            int numOfStand = classroom.countObject(standing);
            System.out.println("There are " + numOfStand + " students of " + standing + " standing in the class.");
         }
         else if (input.charAt(0) == 'D')
            System.out.println("There are " + classroom.getSize() + " students in the class");
         else if (input.charAt(0) == 'W')
         {   
            if(classroom.isEmpty())
               System.out.println("The Class is Empty");
            else
               System.out.println("There is Still Room in the Class");
         }
         else
            System.out.println("Invalid Option: Try Again");
         
         for(int i = 0; i<classroom.toArray().length; i++)
            System.out.println(classroom.toArray()[i]);
      }
   }
}