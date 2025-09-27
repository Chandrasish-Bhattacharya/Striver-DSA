// Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.

// Example 1:
// Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
// Result: 1
// Explanation: Index 1 is the smallest index such that arr[1] >= x.

// Example 2:
// Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
// Result: 3
// Explanation: Index 3 is the smallest index such that arr[3] >= x.

public class Implement_Lower_Bound {
    // Brute Force
    public static int Brute(int[] arr, int x) { // linear search
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x)
                return i;
        }
        return -1;
    }

    // Better
    public static int better(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < x)
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 8, 15, 19 };
        int x = 9;
        System.out.println(better(arr, x));
    }
}
