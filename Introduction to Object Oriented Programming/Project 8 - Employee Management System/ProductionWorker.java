public class ProductionWorker extends Employee
{
   private int shift;
   private double pay;
   public ProductionWorker()
   {
      super();
      shift = 1;
      pay = 0.0;
   } 
   public ProductionWorker(String emp, String number, String date, int time, double rate)
   {
      super(emp, number, date);
      shift = time;
      pay = rate;
   }
   public void setShift(int time)
   {
      shift = time;
   }
   public void setPay (double rate)
   {
      pay = rate;
   }   
   public String getShift()
   {
      switch(shift)
      {
         case 1:
            return("Day");
         case 2:
            return("Night");
         default:
            return("");
      }

   }
   public double getPay()
   {
      return(pay);
   }
   public String toString()
   {
      String invalid = "INVALID SHIFT NUMBER";
      String output = super.toString()
                      + "Shift: " 
                      +((shift==1||shift==2) ? this.getShift():invalid)
                      +"\nHourly Pay Rate: $" 
                      + String.format("%.2f",this.getPay()) 
                      + "\n"; 
      return (output);
   }   
}