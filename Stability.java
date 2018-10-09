/************************************************** 

Purpose/ Description: A program to find the stability index of an array in linear time

**************************************************/




import java.util.*;



public class Problem1 
{
    static int[] Array = new int[] {0,-3,5,-4,-2,3,1,0};
    static ArrayList<Integer> stableArray = new ArrayList<Integer>();
    static int stabilityIndex= 0;
    static int currentIndex;
    
    
    public static void stabilityLoop(int[]A)
    {
      
        for (currentIndex = 0; currentIndex < A.length; currentIndex++ )
      {
            
          if(stabilityCheck(currentIndex, A) != -1)
          {
              stableArray.add(currentIndex);
          }
         
      }
        
        if(!stableArray.isEmpty())
        {
            printStabilityIndex();
        }
        else
        {
            System.out.println("There are no stable indeces");
        }
        
    }
    
    
     public static int stabilityCheck(int index,int [] arr)
    {
      
           int rightSum = 0;
           int leftSum = 0;
       
            if (index == 0)
            {
                for(int i = index + 1; i < arr.length; i++)
                {
                    rightSum = rightSum + arr[i];
                    
                }
                    
            }
            
            
            else if(index == arr.length-1)
            {
                for(int j = arr.length-2; j >= 0; j--)
                {
                    leftSum = leftSum + arr[j];
                  
                }
            }
            
            else
            {
               for (int a = index +1; a < arr.length; a++)
               {
                   rightSum = rightSum + arr[a];
               }
               
               for(int b = index - 1; b >= 0; b-- )
               {
                   leftSum = leftSum + arr[b];
               }
                
                
            }
            
           if(rightSum == leftSum)
           {
              stabilityIndex = index;
              return stabilityIndex;
           }
           
           else
           {
               return -1;
           }

      
    } 
     
     public static void printStabilityIndex()
     {
        
        if(!stableArray.isEmpty())
        {
            System.out.println("Stability index = ");
            for(int element:stableArray)
            {
                
                System.out.println(element);
            }
        }
     }
        
        
     
     
        
    public static void main(String args[])
    {
      stabilityLoop(Array);
    
    }

    
    
    
}
