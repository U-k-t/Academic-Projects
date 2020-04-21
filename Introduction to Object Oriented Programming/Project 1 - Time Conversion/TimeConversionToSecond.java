//TimeConversionToSecond.java
//Jacob Rothman
//CS1400, Section 01
//Project 1 - Time Conversion
//06 September, 2018
import java.util.Scanner;

public class  TimeConversionToSecond{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      int hours, minutes, seconds;
         System.out.print("Enter Hours: ");
         hours = keyboard.nextInt ();
         System.out.print("Enter Minutes: ");
         minutes = keyboard.nextInt ();
         System.out.print("Enter Seconds: ");
         seconds = keyboard.nextInt ();
      int totalTime = hours*3600 + minutes*60 + seconds;
   System.out.println(hours + " hours, "
                         + minutes + " minutes, "
                         + seconds + " seconds is "
                         + "equivalent to " + totalTime + " seconds.");
   }
}
