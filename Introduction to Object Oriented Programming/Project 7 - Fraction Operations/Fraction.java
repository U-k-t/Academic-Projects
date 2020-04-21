// Jacob Rothman
// CS1400, Section 01
// Project 7 – Fractions
// 20 Novemeber 2018
import java.util.Scanner;
public class Fraction
{
   private int numerator;
   private int denominator;
   private static int created=0;
   static Scanner ukt = new Scanner(System.in);
   public Fraction(int top, int bottom)
   {
      if(bottom == 0)
      {
         System.out.println("denominator cannot be 0");
         System.out.println("the fraction is set to 0/1");
         numerator = 0;
         denominator = 1;
      }
      else if (top == 0)
      {
         numerator = 0;
         denominator = 1;
      }
      else
      {
         numerator = top;
         denominator = bottom;
      }
      if(denominator<0)
      {
         numerator = (-1)*numerator;
         denominator = (-1)*denominator;
      }
      if ((numerator%denominator ==0||denominator%numerator==0||this.gcd(Math.abs(numerator),Math.abs(denominator))!=1)&&denominator!=1)
      {
         int ukt = this.gcd(Math.abs(numerator),Math.abs(denominator));
         numerator = numerator/ukt;
         denominator= denominator/ukt;
      }
      created ++;
   }
   public Fraction()
   {
      this(0,1);
   }
   private int gcd (int num1, int num2)
   {
      while (num1 != num2)
      {
         if (num1 > num2)
            num1 = num1 - num2;
         else
            num2 = num2 - num1;
      }
      return num1;
   }
   public Fraction add (Fraction added)
   {
      int common = denominator*added.denominator;
      int numSum = (common*numerator/denominator)+(common*added.numerator/added.denominator);
      return(new Fraction(numSum, common));
   }
   public Fraction subtract (Fraction subtrahend)
   {
      int common = denominator * subtrahend.denominator;
      int numDif = (common*numerator/denominator)-(common*subtrahend.numerator/subtrahend.denominator);
      return(new Fraction(numDif,common));
   }
   public Fraction multiply (Fraction factor)
   {
      return(new Fraction((numerator*factor.numerator),(denominator*factor.denominator)));
   }
   public Fraction divide (Fraction divisor)
   {
      return(new Fraction((numerator*divisor.denominator),(denominator*divisor.numerator)));
   }
   public String toString()
   {
      return(""+numerator + "/" + denominator);
   }
   public void printAsFloat()
   {
      System.out.println((float)numerator/denominator);
   }
   public static int numberOfFractions()
   {
      return(created);
   }
   public static Fraction read()
   {
      System.out.print("enter an integer numerator: ");
      int top =ukt.nextInt();
      System.out.print("enter an integer denominator: ");
      int bottom = ukt.nextInt();
      return(new Fraction(top,bottom));
   }
}