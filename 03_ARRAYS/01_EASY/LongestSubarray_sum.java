// Longest Subarray with sum K | [Postives and Negatives]
// Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
// Example 1:
// Input Format: N = 3, k = 5, array[] = {2,3,5}
// Result: 2
// Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

// Example 2:
// Input Format: N = 3, k = 1, array[] = {-1, 1, 1}
// Result: 3
// Explanation: The longest subarray with sum 1 is {-1, 1, 1}. And its length is 3.
public class LongestSubarray_sum{
    public static int[] Better(int[] arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    return new int[]{i, j + 1}; // j+1 for exclusive end index
                }
            }
        }
        return new int[]{-1, -1}; // No subarray found
    }
    // THE ABOVE FUNCTION GIVE YOU THE SUBARRAY NOT THE ARRAYS LEN 

    public static void main(String[] args) {
        int[] arr = {-1, 1, 1};
        int[] sol = Better(arr, arr.length, 1);
        int len = sol[1]-sol[0];
        System.out.println(len);
        if (sol[0] != -1) {
            for (int i = sol[0]; i < sol[1]; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("No subarray found with sum = 5");
        }
    }
}