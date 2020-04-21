// Jacob Rothman
// CS1400, Section 01
// Project 2 - Determining the Seasons
// 17 September, 2018

import java.util.Scanner;

public class Season{
   public static void main (String[] args){
   
      Scanner kb = new Scanner(System.in);
      System.out.print ("Enter Month (1-12): ");
      int month = kb.nextInt();
      switch(month){
         case 1:
            {System.out.print ("Enter Day (1-31): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 31){
               System.out.println (month + "/" + day 
                                   + " is in the Winter season");            
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 2:
            {System.out.print ("Enter Day (1-28): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 28){
              System.out.println (month + "/" + day
                                   + " is in the Winter season");            
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 3:
            {System.out.print ("Enter Day (1-31): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 20){
               System.out.println (month + "/" + day 
                                   + " is in the Winter season");            
            }
            else if (day>20 && day <=31){
               System.out.println (month + "/" + day 
                                   + " is in the Spring season");
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 4:
            {System.out.print ("Enter Day (1-30): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 30){
               System.out.println (month + "/" + day 
                                   + " is in the Spring season");            
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 5:
            {System.out.print ("Enter Day (1-31): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 31){
               System.out.println (month + "/" + day 
                                   + " is in the Spring season");            
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 6:
            {System.out.print ("Enter Day (1-30): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 20){
               System.out.println (month + "/" + day 
                                   + " is in the Spring season");            
            }
            else if (day>20 && day <=30){
               System.out.println (month + "/" + day 
                                   + " is in the Summer season");
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 7:
            {System.out.print ("Enter Day (1-31): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 31){
               System.out.println (month + "/" + day 
                                   + " is in the Summer season");            
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 8:
            {System.out.print ("Enter Day (1-31): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 31){
               System.out.println (month + "/" + day 
                                   + " is in the Summer season");            
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 9:
            {System.out.print ("Enter Day (1-30): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 20){
               System.out.println (month + "/" + day 
                                   + " is in the Summer season");            
            }
            else if (day>20 && day <=30){
               System.out.println (month + "/" + day
                                   + " is in the Fall season");
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 10:
            {System.out.print ("Enter Day (1-31): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 31){
               System.out.println (month + "/" + day 
                                   + " is in the Fall season");            
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 11:
            {System.out.print ("Enter Day (1-30): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 30){
               System.out.println (month + "/" + day 
                                   + "is in the Fall season");            
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         case 12:
            {System.out.print ("Enter Day (1-31): ");
            int day = kb.nextInt();
            if (day>= 1 && day<= 20){
               System.out.println (month + "/" + day 
                                   + " is in the Fall season");            
            }
            else if (day>20 && day <=31){
               System.out.println (month + "/" + day 
                                   + " is in the Winter season");
            }
            else{
               System.out.println ("Invalid Day!");
               System.exit(0);
            }
            }
            break;
         default:
            System.out.println("Invalid Month!");
            System.exit(0);
            break;
   }
}
}