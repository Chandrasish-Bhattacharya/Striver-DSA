// Floor and Ceil in Sorted Array
// Problem Statement: You're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].
// The floor of x is the largest element in the array which is smaller than or equal to x.
// The ceiling of x is the smallest element in the array greater than or equal to x.

// Example 1:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
// Result: 4 7
// Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

// Example 2:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 8
// Result: 8 8
// Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.
public class FloorandCeil {
    public static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int highBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (mid >= x) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 7, 8, 10 };
        int x = 5;
        System.out.println(
                "The Floor value is : " + arr[lowerBound(arr, x)] + "The Ceiling value is : " + arr[highBound(arr, x)]);
    }
}
