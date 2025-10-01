// Kadane's Algorithm : Maximum Subarray Sum in an Array
// Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and returns its sum and prints the subarray.
// Example 1:

// Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 

// Output: 6 

// Explanation: [4,-1,2,1] has the largest sum = 6. 

// Examples 2: 

// Input: arr = [1] 

// Output: 1 

// Explanation: Array has only one element and which is giving positive sum of 1. 
public class KadanesAlgorithm {
    public static int sol1(int[] arr) {
        int sum = 0, n = arr.length;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Most Optimal
    // Kadane's Algorithm
    public static int sol2(int arr[]) {
        int maxSum = 0, sum = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    // There might be more than one subarray with the maximum sum. We need to print
    // any of them.
    public static int[] follow(int arr[]) {
        int maxSum = 0, sum = 0, n = arr.length;
        int ansStart = 0, ansEnd = 0, Start = 0;
        for (int i = 0; i < n; i++) {
            if (sum == 0)
                Start = i;
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = Start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return new int[] { ansStart, ansEnd };
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(sol2(arr));
        int ans[] = follow(arr);
        for (int i = ans[0]; i <= ans[1]; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}