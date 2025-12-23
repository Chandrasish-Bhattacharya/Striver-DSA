// Problem Statement: Given an array of integers called nums, sort the array in non-decreasing order using the insertion sort algorithm and return the sorted array.

// A sorted array in non-decreasing order is an array where each element is greater than or equal to all preceding elements in the array.
// Example 1:  
// Input:  nums = [7, 4, 1, 5, 3]  
// Output:  [1, 3, 4, 5, 7]  
// Explanation:  The array is sorted in non-decreasing order: 1 ≤ 3 ≤ 4 ≤ 5 ≤ 7.

// Example 2:  
// Input:  nums = [5, 4, 4, 1, 1]  
// Output:  [1, 1, 4, 4, 5]  
// Explanation:  The array is sorted in non-decreasing order: 1 ≤ 1 ≤ 4 ≤ 4 ≤ 5.
class Solution {
    public int[] insertionSort(int[] nums) {
        int n = nums.length; // Size of the array 
        
        // For every element in the array 
        for (int i = 1; i < n; i++) {
            int key = nums[i]; // Current element as key 
            int j = i - 1;
            
            // Shift elements that are greater than key by one position
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            
            nums[j + 1] = key; // Insert key at correct position
        }
        
        return nums;
    }
}
public class Insertion_Sort {
    public static void main(String[] args) {
        // Create an instance of solution class
        Solution solution = new Solution();
        
        int[] nums = {13, 46, 24, 52, 20, 9};
        
        System.out.println("Before Using Insertion Sort: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Function call for insertion sort
        nums = solution.insertionSort(nums);
        
        System.out.println("After Using Insertion Sort: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
