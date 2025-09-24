// Count Maximum Consecutive One's in the array
// Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.
// Examples:
// Example 1:
// Input: prices = {1, 1, 0, 1, 1, 1}
// Output: 3
// Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.
// Input: prices = {1, 0, 1, 1, 0, 1} 
// Output: 2
// Explanation: There are two consecutive 1's in the array. 
public class Consecutive_One{
    public int countOnes(int[] arr){
        int count = 0;
        int max_ones = 0;
        for(int i : arr){
            if(i == 0){
                count = 0;
            }
            if(i == 1){
            count++;
            }
            max_ones = Math.max(count , max_ones);
        }
        return max_ones;
    }
    public static void main(String[] args){
        int[] arr = {1, 1, 0, 1, 1, 1};
        Consecutive_One C = new Consecutive_One();
        System.out.println(C.countOnes(arr));
    }
}