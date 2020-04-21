
public class NodeStack <T> implements UktStack <T>
{
   private Node topNode;
   private int numMode;
   public NodeStack() //Begins the NodeStack
   {
      topNode = null;
   }
   public void push(T input) // Adds Node
   {
      Node tempNode = new Node(input,topNode);
      topNode = tempNode;
   }
   public T pop() //Removes Topmost Node
   {
      T popped = peek();
      topNode = topNode.getNextNode();
      return (popped);
   }
   public T peek() //Look at Topmost Node
   {
      T stackTop;
      if(isEmpty())
         throw new NullPointerException("Stack is Empty"); //Throws Error if Nothing to Look At
      else
         stackTop = (T)topNode.getData(); //Otherwise, Return Topmost Entry
      return stackTop;
   }
   public boolean isEmpty() //Returns if Stack is Empty
   {
      return (topNode==null); // If Node is null, there is no "trail to follow"
   }
   public void clear() //Removes All Entries From the Stack
   {
      topNode = null; // Removes "Trail to Follow"
   }
}
