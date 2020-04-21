// Jacob Rothman
// CS1400, Section 01
// Project 4 – Rock, Paper, Scissors Game
// 09 October, 2018
import java.util.Scanner;
import java.util.Random;
public class RockPaperScissorsGame
{
   static Scanner keyboard = new Scanner (System.in);
   public static void main(String[] args)
   {
      String player,playCheck;
      boolean startReplay;
      do
      {
         player = userChoice();
         String rando = computerChoice();
         determineWinner(rando, player);
         System.out.println();
         if(rando.equalsIgnoreCase(player))
            startReplay=true;
         else
            startReplay = replayCheck();
      }
      while (startReplay == true);
   }
   public static String computerChoice()
   {
      String janken;
      Random ukt = new Random();
      int compChoice = ukt.nextInt(3)+1;
      switch(compChoice)
      {
         case 1:
            janken = "rock";
            break;
         case 2:
            janken = "paper";
            break;
         case 3:
            janken = "scissors";
            break;
         default:
         //this will never happen, so I may as well have some fun with it
            janken = "Spock";
            System.out.println ("Spock beats all with logic");
            break;
      }
      return janken;   
   }
   public static String userChoice()
   {
      boolean validCheck;
      String input;
      System.out.print("Enter rock, paper, or scissors:");
      input = keyboard.nextLine();
      validCheck = isValidChoice(input);
         while (validCheck == false)
         {
            input = keyboard.nextLine();
            validCheck = isValidChoice(input);
         }
      
      return input;
   }
   public static boolean isValidChoice(String choice)
   {
      boolean validChoice;
         if ((choice.equalsIgnoreCase("rock")||choice.equalsIgnoreCase("paper")||choice.equalsIgnoreCase("scissors"))==false)
         {
            validChoice = false;
            System.out.print("Invalid input, enter rock, paper,"
                             + "or scissors:");
         }
         else
            validChoice = true;
      return validChoice;
   }
   public static void determineWinner(String computer, String user)
   {
      System.out.println("The computer's choice was " + computer + ".");
      System.out.println("The user's choice was " + user + ".");
      System.out.println();
      //By determining winner using string lengths, I cut 11 lines
      int userL = user.length();
      int compL = computer.length();
      switch(Math.abs(compL-userL))
      {
         case 0:
            System.out.println("The game is tied!");
            break;
         case 1:
            System.out.println("Paper wraps rock.");
            break;
         case 3:
            System.out.println("Scissors cut paper.");
            break;
         case 4:
            System.out.println("Rock smashes scissors.");
            break;
         default:
            /*this will never happen, so I may as well have some fun with it*/
            System.out.println("Wait a second; this isn't chess!");
            System.exit(0);
            break;
      }
      if (compL - userL == 1 || compL - userL == 3 || compL - userL == -4)
         System.out.println("The computer wins!");
      else if (compL-userL == 0)
         System.out.println ("Get ready to play again...");
      else
         System.out.println("The user wins!"); 
   }   
   public static boolean replayCheck()
   {
      boolean replay;
      String uResp;
      do
      {
         System.out.println("Play again? (y/n)");
         uResp= keyboard.nextLine();
      }
      while(uResp.equalsIgnoreCase("yes")==false&&uResp.equalsIgnoreCase("y")==false&&uResp.equalsIgnoreCase("no")==false&&uResp.equalsIgnoreCase("n")==false);
      if(uResp.equalsIgnoreCase("yes") || uResp.equalsIgnoreCase("y"))
         replay =true;
      else
      {
         replay=false;
         System.exit(0);
      }
      return replay;
   }
}
