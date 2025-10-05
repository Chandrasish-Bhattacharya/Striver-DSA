// 128. Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

// Example 1:

// Input: [100, 200, 1, 3, 2, 4]

// Output: 4

// Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.

// Input: [3, 8, 5, 7, 6]

// Output: 4

// Explanation: The longest consecutive subsequence is 5, 6, 7, and 8.

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static boolean linearSearch(int[] arr, int x) {
        for (int i : arr) {
            if (arr == x)
                return true;
        }
        return false;
    }

    public static int bruteForce(int[] nums) {
        int longest = 0;
        int smallestNo = Integer.MAX_VALUE;
        int maxLongest = 0;
        for (int i = 0; i < nums.length; i++) {
            smallestNo = nums[i];
            longest = 1;
            while (linearSearch(nums, smallestNo + 1)) {
                longest += 1;
                smallestNo += 1;
            }
            maxLongest = Math.max(maxLongest, longest);
        }
        return maxLongest;
    }

    public static int Optimal(int[] nums) {
        int lastSmallest = Integer.MIN_VALUE;
        int count = 0;
        int maxLongest = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmallest) {
                count++;
                lastSmallest = nums[i];
            } else if (nums[i] != lastSmallest) {
                count = 1;
                lastSmallest = nums[i];
            }
            maxLongest = Math.max(count, maxLongest);
        }
        return maxLongest;
    }

    public static void main(String[] args) {
        int[] a = { 100, 200, 1, 2, 3, 4 };
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}
