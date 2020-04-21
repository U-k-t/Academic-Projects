// Jacob Rothman
// CS1400, section 01
// Project 9 – Figures, Triangle, and Box
// 06 November 2018
public class GraphicsTest
{
   public static void main(String[] args)
   {
      //tree
      Triangle top = new Triangle (5, 21);
      Box base = new Box(13, 4, 5);
      top.drawAt(1);
      base.drawAt(0);
      //monitor
      int strL = "-----------------------------".length();
      Box screen = new Box(13,10,strL);
      screen.drawAt(2);
      Box arm = new Box((13+strL/2),1,1);
      arm.drawAt(0);
      arm.drawAt(0);
      int standL = "-------------------".length();
      Box stand = new Box((13+(strL/2)-(standL/2)),1,standL);
      stand.drawAt(0);
      stand.drawAt(0);
      //cake
      Box cake1 = new Box(19,3,2);
      cake1.drawAt(2);
      Box cake2 = new Box(17,4,6);
      cake2.drawAt(0);
      Box cake3 = new Box(14,8,12);
      cake3.drawAt(0);
      Box cake4 = new Box (12,8,16);
      cake4.drawAt(0);
      Box cake5 = new Box (10,8,20);
      cake5.drawAt(0);
      //Triangle Persepctive Shift
      Triangle m1 = new Triangle (5,27);
      Triangle m2 = new Triangle (8,33);
      Triangle m3 = new Triangle (11,39);
      m1.drawAt(2);
      m2.drawAt(0);
      m3.drawAt(0);
      //house
      Box home = new Box (15,15,25);
      Triangle roof = new Triangle(15,25);
      roof.drawAt(2);
      home.drawAt(0);
   }
}
