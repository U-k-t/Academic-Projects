//TimeConversionToHMS.java
//Jacob Rothman
//CS1400, Section 01
//Project 1 - Time Conversion
//06 September, 2018
import java.util.Scanner;

public class  TimeConversionToHMS{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      int totalSec, hours, minutes, seconds;

      System.out.print("Enter Total Seconds: ");
         totalSec = keyboard.nextInt ();

      hours = totalSec/3600;
      minutes = (totalSec%3600)/60;
      seconds = (totalSec%3600)%60;
      System.out.println(totalSec + " seconds is equivalent to " + hours
                         + " hours, " + minutes + " minutes, and "
                         + seconds + " seconds.");
      }
}
