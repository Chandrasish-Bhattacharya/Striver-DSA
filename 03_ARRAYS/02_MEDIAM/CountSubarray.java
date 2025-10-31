// Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.

// A subarray is a contiguous non-empty sequence of elements within an array.
// Example 1:
// Input Format: N = 4, array[] = {3, 1, 2, 4}, k = 6
// Result: 2
// Explanation: The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].

// Example 2:
// Input Format: N = 3, array[] = {1,2,3}, k = 3
// Result: 2
// Explanation: The subarrays that sum up to 3 are [1, 2], and [3].

import java.util.HashMap;
import java.util.Map;

public class CountSubarray {
    public int BruteForceSol(int[] arr, int k) { // this brute force is according to me but for some it is a better
                                                 // approach
        int count = 0, sum = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal Sol
    public int optimalSol(int[] arr, int k) {
        int n = arr.length;
        Map<Integer , Integer> map = new HashMap<>();
        int prevSol = 0, cnt = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            prevSol += arr[i];
            int remove = prevSol - k;
            cnt += map.getOrDefault(remove , 0);
            map.put(prevSol , map.getOrDefault(prevSol, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -1, 0 };
        int k = 0;
        CountSubarray ar = new CountSubarray();
        int cnt = ar.optimalSol(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}
