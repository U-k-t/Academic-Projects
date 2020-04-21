public class Employee
{
   private String name;
   private String idNum;
   private String hireD;
   
   public Employee (String emp, String number, String date)
   {
      name = emp;
      idNum = this.Validate(number);
      hireD = date;
   }
   private String Validate(String toCheck)
   {
      if (toCheck.length()!=5)
         return("");
      else if (toCheck.charAt(3)!='-')
         return("");
      else if(toCheck.charAt(4)<'A'||toCheck.charAt(4)>'Z')
         return("");
      else
      {
         for (int i =0; i<=2; i++)
            if(toCheck.charAt(i)<'0'||toCheck.charAt(i)>'9')
               return("");
      }
      return (toCheck);
   }
   public Employee ()
   {
      name = "";
      idNum = "";
      hireD = "";
   }
   public void setName(String emp)
   {
      name = emp;
   }
   public void setId(String number)
   {
      idNum = number;
   }
   public void setHire(String date)
   {
      hireD = date;
   }
   public String getName()
   {
      return (name);
   }
   public String getId()
   {
      return(idNum);
   }
   public String getHire()
   {
      return(hireD);
   }
   public String toString()
   {
      if(idNum.length()==0)
         idNum = idNum+"INVALID EMPLOYEE NUMBER";
      String output = "Name: " + name + "\nEmployee Number: "
                      + idNum + "\nHire Date: " + hireD + "\n";
      return (output);
   }
}