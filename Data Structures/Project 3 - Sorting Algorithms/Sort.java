import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;  

public class Sort{
   public static void main (String[] args) //Driver
   {
      int testNum = 0;
      final int MAXTESTS = 4; // Change this if adding more test cases
      int numElements = 0;
      int sortType = 0;
      String sortName = "";
      int sorted[] = new int[10];
      long start = 0;
      long end = 0;
      long timeDiff;
      // String asString;
      int[] elements = new int[10];
      Random rand = new Random();
      SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
      while(testNum<MAXTESTS+1) //Parses Through Each Array for Each Sorting Method
      {
         // asString = "";
         switch(testNum) //Sets The Number of Elements
         {
         case 0:
            numElements = 10000;
            elements = new int[numElements];
            break;
         case 1:
            numElements = 20000;
            elements = new int[numElements];
            break;
         case 2:
            numElements = 50000;
            elements = new int[numElements];
            break;
         case 3:
            numElements = 100000;
            elements = new int[numElements];
            break;
         case 4:
            numElements = 500000;
            elements = new int[numElements];
            break;
         default:
            System.out.println("Exiting From testNum Switch");
            System.exit(0);
         }
         for(int i =0; i<elements.length; i++) // Populate the Array With Data
         {
            elements[i]=rand.nextInt(numElements);
            // asString += " " + elements[i];
         }
         // System.out.println("Array as String is: " + asString);
         switch(sortType) // Parses Through Each Sorting Method
         {
            case 0:
               sortName = "Bubble Sort";
               start = System.nanoTime();
               sorted = bubble(elements,numElements);
               end = System.nanoTime();
               break;
            case 1:
               sortName = "Selection Sort";
               start = System.nanoTime();
               sorted = selection(elements);
               end = System.nanoTime();
               break;
            case 2:
               sortName = "Insertion Sort";
               start = System.nanoTime();
               sorted = insertion(elements);
               end = System.nanoTime();               
               break;
            case 3:
               sortName = "Merge Sort";
               start = System.nanoTime();
               sorted = mergeSort(elements);
               end = System.nanoTime();
               break;
            case 4:
               sortName = "Quick Sort";
               start = System.nanoTime();
               sorted = quick(elements,0,elements.length-1);
               end = System.nanoTime();
               break;
            default:
               //System.out.println(sortType);
               System.out.println("Exiting From sortType Switch");
               System.exit(0);
         }
         timeDiff = end-start; 
         System.out.println("Current Time Is : " + time.format(new Date()));
         System.out.printf("Sorting %d elements using %s took %.0f milliseconds \n",numElements,sortName,(double)timeDiff/1000000);
         // System.out.print("Sorted aray is: [ ");
         // for(int j=0; j<sorted.length;j++)
           // System.out.print(sorted[j] + " ");
         // System.out.println("]");
         testNum++;
         if(testNum>MAXTESTS) //Set to Number of Test Cases , Resets After Each Sorting Method Completes Its Test Cases
         {
            sortType++;
            testNum=0;
            System.out.println();
         }
      }
   }
   private static int[] bubble (int[] input , int inLength) //Bubble Sort
   {
      boolean isSwap = true;
      int temp;

      do
      {
         isSwap = false;

         for(int i = 0;i < input.length-1; i++)
         {              
            if(input[i] > input[i+1]){ //If Entry at Index is Greater Than Next Entry
               temp = input[i];
               input[i] = input[i+1]; //Swap Current Entry with Next Entry
               input[i+1] = temp;                   
               isSwap = true;
            }
         }
           
      }while (isSwap); //Repeat Until No More Swapping Occurs
      return input;
   }
   private static int[] selection (int[] input) //Selection Sort
   {
      int min=0;
      int i;
      for (i = 0; i < input.length-1; i++) //For Each Entry in the Array
      {
         min = i; // Assume the First Element is the Current Entry
         for (int j = i + 1; j < input.length; j++) // For Each Following Entry
         {
            if (input[j] < input[min]) // If that Following Entry is Less Than The Current Minimum, Set it to the Minimum 
               min = j;
         }
         if (min != i)  //If the Minimum is Not the Current Entry, Switch Their Positions
         {
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
         }
      }
      return(input);
   }
   private static int[] insertion (int[] input) //Insertion Sort
   {
      int i, j, temp;
      for (i = 1; i < input.length; i++) //For Each Element in the Array (Starting at the Second Element)
      {
         j = i - 1;
         while (j >= 0 && input[j] > input[i] ) // For as long as the element proceeding it is greater than it, swap them.
         {
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i=j;
            j--;
         }
      }
      return(input);
   }
   private static int[] mergeSort (int[] input) //Merge Sort
   {
      int result[] = new int[input.length];
      if(input.length>1) // If Array Contains More than One Element, Split it
      {
         int middle = input.length/2;
         int[] left,right;
         left=right=new int[10];
         if(input.length%2==0)
         {
            left = new int[middle];
            right = new int [middle];
         }
         else
         {
            left = new int[middle];
            right = new int [middle+1];
         }
         for(int i =0; i<left.length; i++)
            left[i] = input[i];
         for (int j=0;j<right.length; j++)
            right[j] = input[j+middle];
         mergeSort(left); //Recursively Call for Each Split Array Until There is Only One Element in Each Array
         mergeSort(right);
         result = merge(input,left,right); // Merge Arrays Back Together
      }
      return(result);
   }
   private static int[] merge(int[] array, int[] left, int[] right) // Merge Sort (Continued)
   {
      int size = left.length+right.length;
      int[] merged = new int[size];
      int index,leftIndex,rightIndex;
      index = leftIndex = rightIndex = 0;
         while ( index < size) {
            if ((leftIndex< left.length) && (rightIndex<right.length)) 
            {
               if (left[leftIndex] < right[rightIndex]) // Compare Entries of the Seperated Arrays and Insert into Merged Array Accordingly
               {
                  merged[index] = left[leftIndex];
                  index++;
                  leftIndex++;
               }                  
                else
                {
                  merged[index] = right[rightIndex];
                  index++;
                  rightIndex++;
                }
            }
            else //Then Add All Remaining Entries to the Merged Array
            {
               if (leftIndex>= left.length)
                  while (rightIndex < right.length)
                  {
                     merged[index] = right[rightIndex];
                     index++;
                     rightIndex++;
                  }
               if (rightIndex >= right.length)            
                  while (leftIndex< left.length)
                  {
                     merged[index] = left[leftIndex];
                     index++;
                     leftIndex++;
                  }
            }
         }
      return(merged);
   }
    public static int[] quick(int[] input, int start, int end) //Quick Sort
    {
    if(end<=start || start>=end){} // Base Case to Prevent Indexes from Reaching Eachother
    else{ 
        int pivot = input[start]; // Set a Pivot Point at the Beginning of the Array
        int index = start+1; 
        int temp; 
        for(int j = start+1; j<= end; j++)
        {
            if(pivot > input[j]) //Compare succeeding entries to the pivot, and move them before the pivot if they are smaller
            {
                temp = input[j]; 
                input[j] = input[index]; 
                input[index] = temp; 
                index++; 
            }
        }
        input[start] = input[index-1]; 
        input[index-1] = pivot; //Reset the Pivot Position and then repeat for each half on either side of the original pivot
        quick(input, start, index-2); 
        quick(input, index, end); 
    }
    return(input);
   }
}


