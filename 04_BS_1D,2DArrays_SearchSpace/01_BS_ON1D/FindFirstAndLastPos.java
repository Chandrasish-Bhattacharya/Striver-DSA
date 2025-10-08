// 34. Find First and Last Position of Element in Sorted Array // Leet Code
// Solved
// Medium
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.
// Last occurrence in a sorted array
// Given a sorted array of N integers, write a program to find the index of the last occurrence of the target key. If the target is not found then return -1.
// Note: Consider 0 based indexing
// Examples:
// Example 1:
// Input: N = 7, target=13, array[] = {3,4,13,13,13,20,40}
// Output: 4
// Explanation: As the target value is 13 , it appears for the first time at index number 2.
// Example 2:
// Input: N = 7, target=60, array[] = {3,4,13,13,13,20,40}
// Output: -1
// Explanation: Target value 60 is not present in the array 
public class FindFirstAndLastPos {
    // there are plenty of ways to solve this problem
    // first lets code the brute force
    public int[] searchRange(int[] nums, int target) { // linear Search solution and it will take a O(n) complexity
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i;
                    last = i;
                } else
                    last = Math.max(i, last);
            }
        }
        return new int[] { first, last };
    }

    // Better using the concept of lower and upper bound concepts
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

    public int[] optimal(int[] nums, int target) {
        int lb = lower(nums, target);
        if (lb == nums.length || nums[lb] != target)
            return new int[] { -1, -1 };
        return new int[] { lb, Upper(nums, target) - 1 };
    }

    public static void main(String[] args) {
        int key = 13;
        int[] v = { 3, 4, 13, 13, 13, 20, 40 };
        FindFirstAndLastPos sol = new FindFirstAndLastPos();
        int[] ans = sol.optimal(v, key);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
