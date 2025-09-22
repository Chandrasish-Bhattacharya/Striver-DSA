// Second Smallest and Second Largest Element in an array 

import java.util.Arrays;

public class SecondSmallest_SecondLargest {
    public static int[] BruteForce(int arr[]) {
        if (arr.length < 2) {
            return new int[] { -1, -1 }; // Not enough elements for second smallest and second largest
        }
        int secondSmallest = 0;
        int secondLargest = 0;
        Arrays.sort(arr);
        secondSmallest = arr[1];
        secondLargest = arr[arr.length - 2];
        return new int[] { secondSmallest, secondLargest };
    }

    static private int secondSmallest(int[] arr, int n) {
        if (n < 2) {
            return -1;
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        return second_small;
    }

    static private int secondLargest(int[] arr, int n) {
        if (n < 2)
            return -1;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            }

            else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 9, 10, 0, 5 };
        int result[] = BruteForce(arr);
        System.out.println("Second Smallest: " + result[0]);
        System.out.println("Second Largest: " + result[1]);
    }
}