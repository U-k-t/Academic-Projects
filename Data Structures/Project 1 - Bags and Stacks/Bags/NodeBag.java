import java.util.Arrays;
public class NodeBag <T> implements UktBag<T>
{
   private Node firstNode;
   private int currentNode;
   public NodeBag() //Creates a Linked Bag
   {
      firstNode = null;
      currentNode = 0;
   }
   public int getSize() //Returns the Number of Objects in the Bag
   {
      return (currentNode);
   }
   public boolean isEmpty() //Returns if the Bag is Empty
   {
      return (currentNode == 0);
   }
   public boolean add (T entry) //Creates a new Node
   {
      Node newN = new Node (entry,firstNode);
      firstNode = newN;
      currentNode++;
      return (true);
   }
   public T remove()//Removes the first Node from the bag
   {
      T removedData = null;
      if (firstNode!=null);
      {
         removedData = (T)firstNode.getData();
         firstNode = firstNode.getNextNode();
         currentNode--;
      }
      return (removedData);
   }
   public boolean remove (T entry) //Removes a Specific Object from the Bag
   {
      Node removedNode = findNode(entry);
      if(removedNode!=null)
      {
         removedNode.setData(firstNode.getData()); //Replace the Removed Node with the First Node's Data
         firstNode = firstNode.getNextNode(); //Remove the First Node
         currentNode--;
         return (true);
      }
      return (false);
   }
   public void clear() //Removes All Objects From the Bag
   {
      while(!isEmpty())
         remove();
   }
   private Node findNode(T entry) // Finds A Specific Object in the Bag
   {
      Node targetNode = firstNode;
      while(targetNode!=null)
         if(targetNode.getData().equals(entry))
            break;
         else
         targetNode = targetNode.getNextNode();
      return (targetNode);   
   }
   public int countObject(T entry) //Counts the Number of Times an Object Occurs in the Bag
   {
      int count = 0;
      Node targetNode = firstNode;
      for (int i=0; i<currentNode; i++)
      {
         if((targetNode.getData().equals(entry))&&(targetNode!=null))
            count++;
         targetNode = targetNode.getNextNode();
      }
      return (count);
   }
   public boolean containsObject(T entry) //Checks if the Bag Contains an Object
   {
      // System.out.println("finding object");
      // if(findNode(entry)!=null)
         // System.out.println("Object found");
      return (findNode(entry)!=null);
   }
   public T[] toArray() //Returns the Bag as an Array
   {
      @SuppressWarnings("unchecked")
      Node targetNode = firstNode;
      int thisIndex=0;
      T[] output = (T[])new Object[currentNode];
      while((thisIndex < currentNode)&&(targetNode!=null))
      {
         output[thisIndex] = (T)targetNode.getData();
         thisIndex++;
         targetNode = targetNode.getNextNode();
      }
      return output;
   }
}