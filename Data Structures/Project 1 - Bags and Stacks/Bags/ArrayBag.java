import java.util.Arrays;
public class ArrayBag <T> implements UktBag<T>
{
   private T[] bagArray;
   private int thisIndex;
   private final int DEFAULT_CAPACITY = 10;
   private final int MAXIMUM_CAPACITY = 80;
   private boolean isValid;
   public ArrayBag(int size) //Create New Bag of Inputted Size
   {
         checkSize(size);
         @SuppressWarnings("unchecked")
         T[] methodBuffer = (T[])new Object[size];
         bagArray = methodBuffer;
         thisIndex = 0;
         isValid = true;
   }
   public ArrayBag() //Create New Bag of DEFAULT_CAPACITY
   {
      @SuppressWarnings("unchecked")
      T[] methodBuffer = (T[])new Object[DEFAULT_CAPACITY];
      bagArray = methodBuffer;
      thisIndex = 0;
      isValid = true;
   }
   public int getSize() //Returns Number of Objects in Bag
   {
      return (thisIndex);
   }
   public boolean isFull() //Returns if Bag is Full
   {
      return (thisIndex == bagArray.length);
   }
   public boolean isEmpty() //Returns if Bag is Empty
   {
      return (thisIndex == 0);
   }
   public boolean add (T entry) //Adds Object to Bag
   {
      verifyCapacity(); //Verifies that Bag is Valid
      if(isFull()) //If Bag is Full, Doubles Bag Size
         resizeArray();
      bagArray[thisIndex] = entry; //Adds Entry to End of Array
      thisIndex++; // Shifts Index
      return (true);
   }
   public T remove() //Removes Last Object from Bag
   {
      if(!isEmpty()) //If Bag is Empty, There is Nothing to Remove
      {
         T removedEntry = bagArray[thisIndex-1]; 
         bagArray[thisIndex-1] = null; //Remove last entry in bag
         thisIndex--;
         return (removedEntry); //Return Removed Entry if Succsessful
      }
      else
         return(null);
   }
   public boolean remove (T entry) //Removes Specific Object from Bag
   {
      if(!isEmpty()&&containsObject(entry))
      {
         int index = getIndex(entry);
         bagArray[index] = bagArray[thisIndex-1];//Replace entry with the last entry in bag
         bagArray[thisIndex-1] = null; //Then Remove the last entry in the bag
         thisIndex--;
         return (true);
      }
      else
         return (false);
   }
   public void clear()//Removes All Objects from the Bag
   {
      if(!isEmpty()) // No Point Wasting Time if Array Is Already Empty
      {
         for (int i=0; i<thisIndex; i++)
            bagArray[i] = null;
         thisIndex--;
      }
   }
      public int getIndex(T entry) //Finds the Index of a Specific Object in the Bag
   {
      int location = -1;
      int index =0;
      // System.out.println("Getting Index of Entry");
      while (index<thisIndex)
      {
         // System.out.println("Checking if entry exists at" + index);
         // System.out.println("Comparing " + bagArray[index] + " and " + entry);
         if(bagArray[index].equals(entry))
         {   
            location=index;
            // System.out.println("Object Found");
            break;
         }
         index++;
      }
      return (location);
   }
   public int countObject(T entry) //Count the Number of Times an Object Occurs in the Bag
   {
      int count = 0;
      for (int i=0; i<thisIndex; i++)
         if(bagArray[i].equals(entry))
            count++;
      return (count);
   }
   public boolean containsObject(T entry) //Checks if an Object Occurs in the Bag
   {
      return (getIndex(entry)>-1);
   }
   public T[] toArray() //Returns the Bag as an Array
   {
      @SuppressWarnings("unchecked")
      T[] output = (T[])new Object[thisIndex];
      for(int i = 0; i < thisIndex; i++)
         output[i] = bagArray[i];
      return output;
   }
   private void verifyCapacity() //Checks the Validity of the Bag
   {
      if(!isValid)
         throw new SecurityException("ArrayBag is Corrupt");
   }
   private void checkSize(int size) //Verifies that Bag Does Not Exceed MAXIMUM_CAPACITY
   {
      if (size > MAXIMUM_CAPACITY)
         throw new IllegalStateException("Cannot create bag" +
                                         " of size >" + MAXIMUM_CAPACITY);       
   }
   private void resizeArray() // Doubles Array Size
   {
      int newSize = bagArray.length*2;
      checkSize(newSize);
      bagArray = Arrays.copyOf(bagArray, newSize);
   }
}