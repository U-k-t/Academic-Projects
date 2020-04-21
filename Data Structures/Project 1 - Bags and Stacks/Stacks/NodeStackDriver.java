import java.util.Scanner;
public class NodeStackDriver
{
   public static void main (String[] args)
   {
      Scanner kb = new Scanner (System.in);
      while (true)
      {
         System.out.println("Type \'EXIT\' to Exit or Enter Infix Expression: ");
         String expression = kb.nextLine(); //Take User Input
         Equation myExpression = new Equation(expression); // Create New Formula Object Using User Input
         if(myExpression.getExpression().toUpperCase().equals("EXIT"))
            System.exit(0); //Allow User to Exit Program
         if (myExpression.checkBalance()) //Check if Paren/Brace/Bracket areBalanced
         {
            String postfix = myExpression.toPostFix(); //If Balanced Equation, Convert to Postfix
            String prefix = myExpression.toPreFix(); //If Balanced Equation, Convert to Prefix
            System.out.println("Expression is Balanced!");
            System.out.println("Expression in postfix form is " + postfix);
            System.out.println("Expression in prefix form is " + prefix);
         }
         else
            System.out.println("Expression is not balanced! Enter a Balanced Expression or Type \'EXIT\' to Exit");
      }      
      
   }
   }
