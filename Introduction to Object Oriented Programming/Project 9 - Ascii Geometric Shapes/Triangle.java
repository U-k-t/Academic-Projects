// Jacob Rothman
// CS1400, section 01
// Project 9 – Figures, Triangle, and Box
// 06 November 2018
public class Triangle extends Figure
{
   private int base;
   public Triangle()
   {
      super();
      base = 3;
   }
   public Triangle (int offset, int b)
   {
      super(offset);
      base = b;
   }
   public void Reset(int newOffset, int newB)
   {
      super.setOffset(newOffset);
      base = newB;
   }
   @Override
   public void drawHere()
   {
      String left = "* ";
      String leftI ="";
      String bottom="";
      String rightI ="";
      int size = super.getOffset();
      String indent = "";
      for(int ukt =1; ukt<=size; ukt++)
         indent+=" ";
      for(int j=1; j<=(Math.floor(base/2)-1); j++)
      {
         leftI +=" ";
      }
      System.out.println(indent+leftI+" *");
      System.out.println(indent+leftI+left+"*");
      for(int i=1; i<=(Math.floor(base/2)-1);i++)
      {   
         leftI+="\b";
         left+=" ";
         rightI+=" ";
         System.out.println(indent+leftI+left+rightI+"*");
      }
      for(int k=0; k<=base-1; k++)
         bottom+="*";
      System.out.println(indent+bottom);
   }
}

