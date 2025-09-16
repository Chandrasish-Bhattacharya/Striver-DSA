// Second Smallest and Second Largest Element in an array 

import java.util.Arrays;

public class SecondSmallest_SecondLargest{
    public static int[] BruteForce(int arr[]){
        if(arr.length < 2){
            return new int[]{-1,-1}; // Not enough elements for second smallest and second largest
        }
        int secondSmallest = 0;
        int secondLargest = 0;
        Arrays.sort(arr);
        secondSmallest = arr[1];
        secondLargest = arr[arr.length - 2];
        return new int[]{secondSmallest,secondLargest};
    }
    
    public static void main(String[] args){
        int arr[] = {1,9,10,0,5};
        int result[] = BruteForce(arr);
        System.out.println("Second Smallest: " + result[0]);
        System.out.println("Second Largest: " + result[1]);
    }
}