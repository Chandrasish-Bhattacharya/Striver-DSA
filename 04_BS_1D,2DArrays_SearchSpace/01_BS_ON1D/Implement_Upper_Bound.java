// Implement Upper Bound
// Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the upper bound of x.
// Example 1:
// Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
// Result: 3
// Explanation: Index 3 is the smallest index such that arr[3] > x.

// Example 2:
// Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
// Result: 4
// Explanation: Index 4 is the smallest index such that arr[4] > x.

public class Implement_Upper_Bound {
    public static int brute(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x)
                return i;
        }
        return -1;
    }

    public static int best(int[] a, int x) {
        int low = 0, high = a.length - 1;
        int ans = 0;
        while (low < high) {
            int mid = (high + low) / 2;
            if (a[mid] > x){
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 9, 15, 19 };
        int x = 9;
        System.out.println(best(arr, x));
    }
}
