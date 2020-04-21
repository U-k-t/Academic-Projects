public class Equation
{
   private String usrExpression;
   public Equation(String expression) //Creates an Expression Equal to the Inputted String
   {
      usrExpression = expression;
   }
   public Equation () //Creates an Empty Expression
   {
      this("");
   }
   public String getExpression () //Returns the Stored Expression
   {
      return (usrExpression);
   }
   public void setExpression(String newExpression) // Sets the Stored Expression to a New Value
   {
      usrExpression = newExpression;
   }
   public String toPostFix() // Converts Infix Expression to Postfix
   {
      String expression = "";
      NodeStack opStack = new NodeStack();
      for(int i =0; i<getExpression().length(); i++) 
      {
         char ch = getExpression().charAt(i); // For Each Character In The Expression, Check Its Value
         if((ch>='a' && ch<='z')  || (ch >='A' && ch<='Z') || (ch >= '0' && ch <='9'))
            expression = expression+ch; //If It is A Variable or Integer, Append to Expression
         else // Otherwise Use the Operator Stack
            switch (ch){
               case '^': // Exponents are of the Highest Precedent, so They Will Always be Pushed
                  opStack.push(ch);
                  break;
               case '+': case '-': case'*' :case'/':
                  if (!opStack.isEmpty() && doIPop(ch, (char)opStack.peek())) //If the Stack is Not Empty, and Precedence Comes into Play, Pop then Push
                  {
                     expression = expression + opStack.pop();
                     opStack.push(ch);
                  }
                  else // Otherwise Just Push
                  {
                     opStack.push(ch);
                  }
                  break;
               case '(': // Open Parentheses Will Always Push
                  opStack.push(ch);
                  break;
               case ')': // Parse Until Opening Paren, Adding Everything to Postfix Expression Along the Way
                  while(!opStack.isEmpty() && (char)opStack.peek()!='(')
                  {
                     expression = expression + (char)opStack.pop();
                  }
                  opStack.pop();
                  break;
               default: break;                 
      }
      }
      while(!opStack.isEmpty()) // Once All Characters are Checked, Clear the Remaining Entries in the Stack
      {
         expression = expression+opStack.pop();
      }
   
      return expression;
   }
   public String toPreFix() // Converts Infix Expression to Prefix
   {
      String expression = "";
      NodeStack opStack = new NodeStack();
      NodeStack charStack = new NodeStack();
      NodeStack reversedStack = new NodeStack();
      int counter = 0;
      for (int i = 0; i<getExpression().length(); i++)
      {
         char ch = getExpression().charAt(i); //Checks Each Character in Expression
         if((ch>='a' && ch<='z')  || (ch >='A' && ch<='Z') || (ch >= '0' && ch <='9')) // If AlphaNumeric, Push to charStack
            charStack.push(ch);
         else
            switch (ch){ //if Operand, Push to OpStack Depedent on Precedence
               case '^':
                  opStack.push(ch);
                  break;
               case '+':case '-':case '*':case'/':
                  if (!opStack.isEmpty()&& !doIPop(ch, (char)opStack.peek())) // When Precedence Calls for the Need to Pop
                  {
                     expression = expression + (char)opStack.pop(); //Pop Operand
                     opStack.push(ch);
                     while(!charStack.isEmpty()) //Reverse All Items in CharStack
                     {
                        reversedStack.push((char)charStack.pop());
                        counter ++;
                     }
                     while(!reversedStack.isEmpty()&&counter>1) //Append All But 1 Variable to the Expression
                     {
                        expression = expression + (char)reversedStack.pop();
                        counter --;
                     }
                     charStack.push((char)reversedStack.pop());//Return Remaining Variable to the CharStack
                  }
                  else
                     opStack.push(ch); // Otherwise Push to the opStack
                  break;
               case '(':
                  while(!opStack.isEmpty())
                     expression = expression + (char)opStack.pop(); // When Parenthesis Open, Pop All Preceding Operators to the Expression
                  opStack.push(ch);
               case ')': // When Parenthesis Close, Pop All Operators Inside to the Expression
                  while(!opStack.isEmpty() && (char)opStack.peek()!='(')
                  {
                     expression = expression + (char)opStack.pop();
                  }
                  if(!opStack.isEmpty())
                     opStack.pop(); //Clear the Open Parenthesis
                  break;
               default: break;                   
      }
      }
      while (!charStack.isEmpty()) //Reverse Remaining Characters
         reversedStack.push(charStack.pop());
      while(!opStack.isEmpty()) // Append Remaining Operators
         expression = expression + (char)opStack.pop();
      while(!reversedStack.isEmpty()) //Append Remaining Characters in Proper Order
         expression = expression + (char)reversedStack.pop();
     return (expression);
   }
   public boolean checkBalance() // Determines if Paren/Braces/Brackets are Balanced
   {
      NodeStack parenStack = new NodeStack();
      boolean balanced = true;
      int character = 0;
      char c;
      while (balanced && (character < getExpression().length()))
      {   
         c = getExpression().charAt(character);
         switch(c){ //For Each Character in the Expression
            case '(':case '[': case '{': //If it is an opening paren/bracket/brace, push
               parenStack.push(c);
               break;
            case ')':case ']':case '}':
               if(isPair((char)parenStack.peek(), c)) // if the next closing paren/bracket/brace matches the most recently encountered, then pop
                  parenStack.pop();
               else
                  balanced = false; // otherwise the equation is imbalanced
               break;
         }
         character++;
      }
      if(balanced==true)
         return true;
      else
         return false;
   }
   private boolean isPair(char open, char close) //Determines if Paren/Braces/Brackets are a Matching Pair
   {
      if(open == '[' && close == ']') // Pairs of Brackets
         return true;
      else if (open == '{' && close == '}') //Pairs of Braces
         return true;
      else if (open =='(' && close == ')') //Pairs of Parenthesis
         return true;
      else
         return false;
   }
   private boolean doIPop (char toCheck, char top) //Determines Precedence of Operators
   {
      if ((toCheck == '+' || toCheck == '-') && (top =='*' || top == '/')) // If Top is of Higher Precedence Than toCheck, then Pop
         return true;
      else if ((toCheck == '+' || toCheck == '-') && (top =='+' || top == '-')) // If Operators are of Same Precedence, then Pop
         return true;
      else if ((toCheck == '*' || toCheck == '/') && (top =='*' || top == '/')) // If Operators are of Same Precedence, then Pop
         return true;
      else if ((toCheck == '+' || toCheck == '-' || toCheck =='*' || toCheck == '/') && top == '^') // If top is exponent (Highest Precedence) then Pop
         return true;
      else
         return false; // No Need to Pop
   }
   public String toString() // Outputs Object as String
   {
      return(getExpression()); //Prints Object as its Stored String Expression
   }

}
