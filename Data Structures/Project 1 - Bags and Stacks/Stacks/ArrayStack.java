import java.util.Arrays;
public class ArrayStack <T> implements UktStack <T>
{
   private T[] resizableStack;
   private int indexLessOne = -1;
   private final int MAX_SIZE = 40;
   private final int DEFAULT_SIZE = 10;
   private boolean integrityOK = false; 
   public ArrayStack(int size) //Creates ArrayStack of Specific Size
   {
      integrityOK = false;
      @SuppressWarnings("unchecked")
      T[] methodBuffer = (T[])new Object[size];
      resizableStack = methodBuffer;
      integrityOK = true;
   }
   public ArrayStack() //Creates ArrayStack of DEFAULT_SIZE
   {
      @SuppressWarnings("unchecked")
      T[] methodBuffer = (T[])new Object[DEFAULT_SIZE];
      resizableStack = methodBuffer;
      integrityOK = true;
   }
   public void push(T input) // Adds Object to ArrayStack
   {
      if(indexLessOne>=resizableStack.length-1) // If Stack is Full, Double Size
         doubleStack();
      resizableStack[indexLessOne+1] = input; // Add New Element to Next Index
      indexLessOne++;
   }
   public T pop() //Removes Topmost Object from ArrayStack
   {
      T stackTop;
      if(isEmpty())
         throw new NullPointerException("Stack is Empty"); //Throw Error if Nothing to Remove
      else
      {
         stackTop = resizableStack[indexLessOne]; //Otherwise Store Topmost Entry, and then Set it to Null
         resizableStack[indexLessOne] = null;
         indexLessOne--; //Reindex
      }
      return stackTop; //Return the Removed Entry
   }
   public T peek() //Look at Topmost Object from ArrayStack
   {
      T stackTop;
      if(isEmpty())
         throw new NullPointerException("Stack is Empty"); //Throws Error if Nothing to Look At
      else
         stackTop = resizableStack[indexLessOne]; //Otherwise, Return Topmost Entry
      return stackTop;
   }
   public boolean isEmpty() //Returns if Stack is Empty
   {
      return (indexLessOne==(-1)); //Index [0] -1 == -1
   }
   public void clear() //Removes All Entries From the Stack
   {
      while(indexLessOne >=0 )
      {
         pop(); //Pop Entries Until Stack is Empty
      }
   }
   private void checkSpace(int capacity) //Determines if Stack Size Exceeds Maximum Capacity
   {
      if (capacity > MAX_SIZE)
         throw new IllegalStateException ("Cannot Create Stack"+
            "with Capacity Greater Than " + MAX_SIZE);
   }
   private void doubleStack() // Doubles Stack Size
   {
      int reSize = 2*resizableStack.length;
      checkSpace(reSize); //Checks if Stack Size Exceeds Maximum Capacity
      resizableStack = Arrays.copyOf(resizableStack, reSize); //If it Doesnt, Double Size
   }
}
