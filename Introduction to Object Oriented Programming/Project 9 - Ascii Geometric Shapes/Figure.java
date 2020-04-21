// Jacob Rothman
// CS1400, section 01
// Project 9 – Figures, Triangle, and Box
// 06 November 2018

public abstract class Figure
{
   private int offset;
   public Figure()
   {
      offset = 0;
   }
   public Figure(int theOffset)
   {
      offset = theOffset;
   }
   public void setOffset(int newOffset)
   {
      offset = newOffset;
   }
   public int getOffset()
   {
      return(offset);
   }
   public void drawAt(int lineNumber)
   {
      for (int count = 0; count < lineNumber; count++)
         System.out.println();
      drawHere();
   }
   public abstract void drawHere();
}