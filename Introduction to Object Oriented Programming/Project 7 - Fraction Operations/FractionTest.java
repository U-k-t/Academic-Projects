// Jacob Rothman
// CS1400, Section 01
// Project 7 – Fractions
// 20 Novemeber 2018
public class FractionTest
{
   public static void main(String[] args)
   {
      System.out.println("Please enter 2 fractions --");
      System.out.println("Fraction 1:");
      Fraction f1 = Fraction.read();
      System.out.println("Fraction 2:");
      Fraction f2 = Fraction.read();
      Fraction sum = f1.add(f2);
      System.out.printf("%s + %s = %s = ",f1, f2,sum);
      sum.printAsFloat();
      Fraction difference = f1.subtract(f2);
      System.out.printf("%s - %s = %s = ",f1, f2,difference);
      difference.printAsFloat();
      Fraction product = f1.multiply(f2);
      System.out.printf("%s * %s = %s = ",f1, f2,product);
      product.printAsFloat();
      Fraction quotient = f1.divide(f2);
      System.out.printf("%s / %s = %s = ",f1, f2,quotient);
      quotient.printAsFloat();
      System.out.println();
      System.out.printf("%d fractions have been created.\n\n", Fraction.numberOfFractions());
      
   }
}