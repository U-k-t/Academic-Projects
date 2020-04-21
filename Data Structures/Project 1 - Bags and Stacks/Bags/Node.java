public class Node <T>
{
   private T storedData;
   private Node next;
   
   public Node(T data,Node nextNode) //Creates Node
   {
      storedData = data;
      next = nextNode;
   }
   public Node (T data) //Creates Node with No Reference
   {
      this (data, null);
   }
   public T getData() //Returns Node's Data
   {
      return(storedData);
   }
   public void setData(T newData) //Sets Node's Data
   {
      storedData = newData;
   }
   public Node getNextNode() //Returns the Node's Reference
   {
      return (next);
   }
   public void setNextNode(Node newNext) //Sets the Node's Reference
   {
      next = newNext;
   }
}