// Bubble Sort Algorithm
// Problem Statement: Given an array of N integers, write a program to implement the Bubble Sorting algorithm.

// Examples:

// Example 1:
// Input: N = 6, array[] = {13,46,24,52,20,9}
// Output: 9,13,20,24,46,52
// Explanation: After sorting we get 9,13,20,24,46,52


// Input: N = 5, array[] = {5,4,3,2,1}
// Output: 1,2,3,4,5
// Explanation: After sorting we get 1,2,3,4,5

public class BubbleSort {
    public static void sol(int[] arr){
        for(int i = 0; i< arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
    }
     public static void main(String args[]) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before Using Bubble Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sol(arr);
        System.out.println("After Using Bubble Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
    }
}
