// Jacob Rothman
// CS1400, section 01
// Project 5 – Temperature Conversion Object
// 24 October, 2018
public class Temperature
{
   private double degrees;
   private char scale;
   // No Param Constructor
   public Temperature()
   {
      degrees = 0;
      scale = 'C';
   }
   // Temperature Constructor
   public Temperature(double temp)
   {
      degrees = temp;
      scale = 'C';
   }
   // Scale Constructor
   public Temperature(char sym)
   {
      degrees = 0;
      scale = sym;
   }
   // Two Param Constructor
   public Temperature(double temp, char sym)
   {
      degrees = temp;
      scale = sym;
   }
   //Returns Celsius Temp
   public double getCel()
   {
      if(scale=='f'||scale=='F')
      {
         double degreesC = (degrees-32)*5/9;
         return degreesC;
      }
      else
         return degrees;
   }
   //Returns Farenheit Temp
   public double getFar()
   {
      if(scale =='c'||scale=='C')
      {
         double degreesF = (degrees*9/5)+32;
         return degreesF;
      }
      else
         return degrees;
   }
   //Returns Scale, Included for Correctness
   public char getScale()
   {
      return scale;
   }
   //Stores New Value in "degrees"
   public void setDeg(double temp)
   {
      degrees = temp;
   }
   //Stores New Value in "scale"
   public void setScale(char sym)
   {
      if(sym=='f'||sym=='c'||sym=='F'||sym=='C')
            scale = sym;
      else
      {
            System.out.println("Invalid Scale");
            System.exit(0);
      }
   }
   //Stores New Value in Both Fields
   public void setAll(double temp, char sym)
   {
      degrees = temp;
      scale = sym;
   }   
   // Tests for Temperature Equality in C
   public boolean testEqual(double deg1)
   {
      boolean isEqual = (getCel() == deg1);
      return isEqual;
   }
   //Tests for Larger Temperature in C
   public boolean testGreater(double deg1)
   {
      boolean isGreater = (getCel()> deg1);
      return isGreater;
   }
   //Tests for Smaller Temperature in C
   public boolean testLess(double deg1)
   {
      boolean isLess = (getCel()<deg1);
      return isLess;
   }
}