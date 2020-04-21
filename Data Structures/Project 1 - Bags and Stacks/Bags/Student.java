public class Student
{
   private int studentID;
   private String first_name, last_name, academicLevel;
   
   public Student() //Creates Empty Student Object
   {
      this(0,null,null,null);
   }
   public Student(int idNum, String first, String last, String academicStanding) //Creates Student Object Based on Inputted Fields
   {
      studentID = idNum;
      first_name = first;
      last_name = last;
      if(!(academicStanding==null|| academicStanding.equalsIgnoreCase("Freshman") || academicStanding.equalsIgnoreCase("Sophomore")||
            academicStanding.equalsIgnoreCase("Junior")||academicStanding.equalsIgnoreCase("Senior") //Verifies Academic Standing is Valid Input
            ))
         throw new IllegalStateException("Academic Level Must Be One of: \n- Freshman\n" +
                                                   "- Sophomore\n- Junior\n- Senior");
      academicLevel = academicStanding;
   } 
   public int getID() // Returns Student ID
   {
      return (studentID);
   }
   public String getFirst() //Returns First Name
   {
      return(first_name);
   }
   public String getLast() //Returns Last Name
   {
      return last_name;
   }
   public String getStanding() //Returns Academic Standing
   {
      return (academicLevel);
   }
   public void setID (int idNum) //Sets Student ID
   {
      studentID = idNum;
   }
   public void setFirst(String first) //Sets First Name
   {
      first_name = first;
   }
   public void setLast(String last) //Sets Last Name
   {
      last_name = last;
   }
   public void setStanding(String standing) //Sets Academic Standing
   {
      if(!(standing==null||standing.equalsIgnoreCase("Freshman") || standing.equalsIgnoreCase("Sophomore")||
            standing.equalsIgnoreCase("Junior")||standing.equalsIgnoreCase("Senior") //Once Again Verifies Standing is Valid Input
            ))
         throw new IllegalStateException("Academic Level Must Be One of: \n- Freshman\n" +
                                                   "- Sophomore\n- Junior\n- Senior");
      academicLevel = standing;
   }
   public boolean equals (Object check) //Overrides the equals method for comparing Objects
    {
       if (check instanceof Integer) //If Object is an Integer, Compare it to the Student ID
         return (Integer.compare((int)check,getID()) == 0);
      else //Otherwise Compare it to Academic Standing (Will Always Be Able to Read as String due to Scanner.nextline() )
         return(check.toString().toUpperCase().compareTo(getStanding().toUpperCase()) == 0);
      
    }
   public String toString () //Prints Student Object as ID, Name, and Standing
   {
      return("ID: " + studentID + "\nName: " + first_name + " " + last_name + "\nStanding: " + academicLevel);
   }
}