// Jacob Rothman
// CS1400, section 01
// Project 5 – Temperature Conversion Object
// 24 October, 2018
public class TemperatureTest
{
   public static void main (String[] args)
   {
      Temperature t1 = new Temperature();
      Temperature t2 = new Temperature(-40);
      Temperature t3 = new Temperature('F');
      Temperature t4 = new Temperature(32,'F');
      System.out.println("Test 4 constructors...");
      System.out.println("t1: created by no-arg constructor");
      System.out.printf("t2: created by 1-arg constructor with " 
                        + "initial degree to be %.0f \n",t2.getCel());
      // t2 Retrieves Temperature Value
      System.out.printf("t3: created by 1-arg constructor with "
                        + "initial scale to be '%c' \n", t3.getScale());
      // t3 Retrieves Temperature Scale
      System.out.printf("t4: created by 2-arg constructor with " 
                        + "initial temperature " 
                        + "%.0f %c \n",t4.getFar(),t4.getScale());
      // t4 Retrieves Both Stored Values
      System.out.println();
      System.out.println("Test 2 getter methods...");
      System.out.printf("t1 is %5.1f C = "
                        + "%5.1f F \n",t1.getCel(),t1.getFar());
      System.out.printf("t2 is %5.1f C = "
                        + "%5.1f F \n",t2.getCel(),t2.getFar());
      System.out.printf("t3 is %5.1f C = "
                        + "%5.1f F \n",t3.getCel(),t3.getFar());
      System.out.printf("t4 is %5.1f C = "
                        + "%5.1f F \n",t4.getCel(),t4.getFar());
      System.out.println();
      System.out.println("Test 3 comparison methods...");
      // Oh My G, the Upcoming Formatting
      System.out.println("is t1 (<, ==, >) t2? results are ("
                        +(t1.testLess(t2.getCel()) ? "true":"false")
                        + ", " 
                        + (t1.testEqual(t2.getCel()) ? "true":"false")
                        + ", "
                        + (t1.testGreater(t2.getCel()) ? "true":"false")
                        + ")");        
      System.out.println("is t2 (<, ==, >) t3? results are ("
                        +(t2.testLess(t3.getCel()) ? "true":"false")
                        + ", " 
                        + (t2.testEqual(t3.getCel()) ? "true":"false")
                        + ", "
                        + (t2.testGreater(t3.getCel()) ? "true":"false")
                        + ")"); 
      System.out.println("is t1 (<, ==, >) t4? results are ("
                        +(t1.testLess(t4.getCel()) ? "true":"false")
                        + ", " 
                        + (t1.testEqual(t4.getCel()) ? "true":"false")
                        + ", "
                        + (t1.testGreater(t4.getCel()) ? "true":"false")
                        + ")");
      System.out.println();
      System.out.println("Test 3 setter methods...");
      //Scale Changes Demonstrated by .getCel() Correctness
      System.out.println("changing t1 from 0 C to -40 C...");
      t1.setDeg(-40);
      System.out.printf("t1 is %.1f C = %.1f F"
                        + "\n",t1.getCel(),t1.getFar());
      System.out.println();
      System.out.println("changing t3 from 0 F to 100 C...");
      t3.setAll(100,'C');
      System.out.printf("t3 is %.1f C = %.1f F"
                        + "\n",t3.getCel(),t3.getFar());
      System.out.println();
      System.out.println("changing t4 from 32 F to 32 C...");
      t4.setScale('C');
      System.out.printf("t4 is %.1f C = %.1f F"
                        + "\n",t4.getCel(),t4.getFar());
      System.out.println();
      System.out.println("set t2's scale to 'G'...");
      t2.setScale('G');
   }
}