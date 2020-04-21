// Jacob Rothman
// CS 1400, Section 01
// Project 6 – Driver License Exam
// 25 October, 2018
import java.util.Scanner;
public class DriverTest
{
   public static void main(String[] args)
   {
      Scanner ukt = new Scanner (System.in);
      char[] ansKey = {'A','A','A','A','A','B','B','B','B','B',
                       'C','C','C','C','C','A','A','A','A','A'};
      char[] usrAns = new char[ansKey.length];
      System.out.println("Enter your answers to the exam questions.");
      for(int i = 0; i<ansKey.length; i++)
      {
         System.out.printf("Question %d: ",i+1);
         usrAns[i] = ukt.nextLine().toUpperCase().charAt(0);
      }
      int badAns = gradeExam(ansKey,usrAns);
      int[] wrongQs = makeMissedArray(ansKey, usrAns, badAns);
      System.out.printf("** Correct answers: %d \n", ansKey.length-badAns);
      System.out.printf("** Incorrect answers: %d \n", badAns);
      System.out.print("** ");
      System.out.println(badAns>=6 ? "You failed the exam.":"You passed"
                        + " the exam.");
      System.out.println ("You missed the following questions: ");
      for (int j =0; j<wrongQs.length; j++)
         System.out.printf("%d ", wrongQs[j]+1);
      System.out.println();
   }
   public static int gradeExam(char[] correct, char[] student)
   {
      //Determine Incorrrect Answers, Not Case Sensitive
      int numWrong=0;
      for (int k = 0; k<correct.length; k++)
         if(correct[k]!=student[k])
            numWrong++;
      return numWrong;
   }
   public static int[] makeMissedArray(char[] correct, char[] student, int numIncorrect)
   {
      //Create an Array of Missed Questions
      int[] missedQs = new int[numIncorrect];
      int qCount = 0;
      for( int m =0; m<student.length; m++)
      {
         if(correct[m]!=student[m])
         {
            missedQs[qCount] = m;
            qCount++;
         }
      }
      return missedQs;
   }
}