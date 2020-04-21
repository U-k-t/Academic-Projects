import java.util.Vector;
public final class VectorStack <T> implements UktStack <T>
{
   private Vector<T> stackVector;
   private static final int DEFAULT_CAPACITY = 40;
   private static final int MAXIMUM_CAPACITY = 640;
   private boolean integrityOK;
   public VectorStack() //Initializes the VectorStack
   {
      this(DEFAULT_CAPACITY);
   }
   public VectorStack(int size)
   {
      integrityOK = false;
      checkSpace(size);
      stackVector = new Vector<>(size);
      integrityOK = true;
   }
   public void push(T input) // Adds Object
   {
      stackVector.add(input);
   }
   public T pop() //Removes Topmost Object
   {
      if(isEmpty())
        throw new NullPointerException("Stack is Empty");
     else
        return (stackVector.remove(stackVector.size()-1)); //Removes Last Entry of Stack
   }
   public T peek() //Look at Topmost Object
   {
      T stackTop;
      if(isEmpty())
         throw new NullPointerException("Stack is Empty"); //Throws Error if Nothing to Look At
      else
         stackTop = stackVector.lastElement(); //Otherwise, Return Topmost Entry
      return stackTop;
   }
   public boolean isEmpty() //Returns if Stack is Empty
   {
      return (stackVector.isEmpty());
   }
   public void clear() //Removes All Entries From the Stack
   {
      stackVector.clear();
   }
   private void checkSpace(int capacity) //Determines if Stack Size Exceeds Maximum Capacity
   {
      if (capacity > MAXIMUM_CAPACITY)
         throw new IllegalStateException ("Cannot Create Stack"+
            "with Capacity Greater Than " + MAXIMUM_CAPACITY);
   }
}
