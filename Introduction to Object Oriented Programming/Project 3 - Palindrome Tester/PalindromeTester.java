// Jacob Rothman
// CS1400, Section 01
// Project 3 - Palindrome Tester
// 01 October, 2018

import java.util.Scanner;

public class PalindromeTester
{
   public static void main (String[] args)
   {
      Scanner kb = new Scanner (System.in);
      int blankcheck = 0;
      int palCount = 0;
      do
      {
      System.out.println ("Enter a word, phrase, or sentence (blank"
                           + "line to stop): ");
      String toCheck = kb.nextLine();
      if(toCheck.equals("")== true) //blank line abort sequence
      {
         System.out.println ("You found " + palCount + " palindromes.");
         System.out.println ("Thank you for using PalindromeTester.");
         blankcheck++;
         System.exit(0);
      }
      int checkLength = toCheck.length(); // find length
      int j = 0;
      String noChar = "";
      while (j<=  checkLength-1)
      {
         if (toCheck.toLowerCase().charAt(j)>='a' && toCheck.toLowerCase().charAt(j)<='z')
         {
            noChar = noChar + toCheck.charAt(j);
            j++;
         }
         else
            j++;
      }
      int charLength = noChar.length();
      String bwdOut = "";
      for (int i = charLength-1; i>=0; i--) //concatenate in reverse
      {
         bwdOut = bwdOut + noChar.charAt(i);
      }     
      if(bwdOut.equalsIgnoreCase(noChar)== true)
      {
         System.out.println("Palindrome \n");
         palCount++; //count palindromes found
      }
      else
         System.out.println("Not a palindrome \n");
      }
      while (blankcheck < 1); //loop
      
   }
}

