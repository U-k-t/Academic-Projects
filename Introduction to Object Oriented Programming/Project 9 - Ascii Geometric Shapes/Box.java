// Jacob Rothman
// CS1400, section 01
// Project 9 – Figures, Triangle, and Box
// 06 November 2018
public class Box extends Figure
{
   private int height;
   private int width;
   public Box(int offset, int h, int w)
   {
      super(offset);
      height = h;
      width = w;
   }
   public Box()
   {
      super();
      height = 1;
      width = 1;
   }
   
   public void Reset(int newOffset, int newH, int newW)
   {
      super.setOffset(newOffset);
      height = newH;
      width = newW;
   }
   @Override
   public void drawHere()
   {
      String edge = "-";
      String center = "|";
      int size = super.getOffset();
      String indent = "";
      for(int ukt =1; ukt<=size; ukt++)
         indent+=" ";
      for (int i =1; i<=(width-1); i++)
      {
         edge+="-";
         if(i!=(width-1))
            center+=" ";
         else
            center +="|";
      }
      for(int j = 0; j<=(height-1); j++)
      {
         if(j==0 || j==(height-1))
            System.out.println(indent+edge);
         else
            System.out.println(indent+center);
      }
   }
}