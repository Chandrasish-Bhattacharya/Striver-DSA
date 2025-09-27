// Sort an array of 0s, 1s and 2s
// Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Input: nums = [2,0,1]
// Output: [0,1,2]

// Input: nums = [0]
// Output: [0]
import java.util.ArrayList;
import java.util.Arrays;

public class Sortanarrayof0s_1s_2s {
    // Brute Force
    public static void bruteForce(int[] arr) {
        Arrays.sort(arr);
    }

    public static ArrayList<Integer> better(int[] arr) {
        ArrayList<Integer> a = new ArrayList<>();
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                countZero++;
            else if (arr[i] == 1)
                countOne++;
            else
                countTwo++;
        }
        for (int i = 0; i < countZero; i++) {
            a.add(0);
        }
        for (int i = countZero; i < countZero + countOne; i++) {
            a.add(1);
        }
        for (int i = countOne; i < countZero + countOne + countTwo; i++) {
            a.add(2);
        }
        return a;
    }

    // Swap elements at indices a and b in the array
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Optimal sorting method for arrays containing only 0s, 1s, and 2s
    public static void best(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 2, 1, 1, 0 };
        best(arr);
        System.out.println(Arrays.toString(arr));
    }
}