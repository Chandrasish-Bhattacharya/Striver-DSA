// Count Occurrences in Sorted Array
// Problem Statement: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.
// Example 1:
// Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
// Output: 4
// Explanation: 3 is occurring 4 times in 
// the given array so it is our answer.

// Example 2:
// Input: N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
// Output: 5
// Explanation: 2 is occurring 5 times in the given array so it is our answer.
public class CountOccurrences {
    public static int Brute(int[] nums, int k) {
        int count = 0;
        for (int i : nums) {
            if (i == k) {
                count++;
            }
        }
        return count;
    }

    public int lower(int[] nums, int target) {
        int idx = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] >= target) {
                idx = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return idx;
    }

    public int Upper(int[] nums, int target) {
        int idx = -1;
        int low = 0, high = nums.length;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] > target) {
                idx = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return idx;
    }

    public int sol(int[] nums, int target) {
        int lb = lower(nums, target);
        if (lb == nums.length || nums[lb] != target)
            return -1;
        return ((Upper(nums, target) - 1) - lb) + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 11, 13 };
        int x = 8;
        // int ans = Brute(arr, x);
        CountOccurrences sol = new CountOccurrences();
        
        System.out.println("The number of occurrences is: " + sol.sol(arr, x));
    }
}
