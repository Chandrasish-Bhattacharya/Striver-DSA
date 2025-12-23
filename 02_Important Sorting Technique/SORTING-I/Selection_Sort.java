// Selection Sort Algorithm
// Problem Statement: Given an array of N integers, write a program to implement the Selection sorting algorithm.
// Examples
// Example 1:
// Input: N = 6, array[] = {13,46,24,52,20,9}
// Output: 9,13,20,24,46,52
// Explanation: After sorting the array is: 9, 13, 20, 24, 46, 52

// Example 2:
// Input: N=5, array[] = {5,4,3,2,1}
// Output: 1,2,3,4,5
// Explanation: After sorting the array is: 1, 2, 3, 4, 5
class Solution{
    public void SelectionSort(int[] arr){
        for(int i = 0 ; i<arr.length ; i++){
            int minValue = i;
            for(int j = i + 1; j<arr.length ; j++){
                if(arr[j]<arr[minValue]){
                    minValue = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minValue];
            arr[minValue] = temp;
        }
    }
}
public class Selection_Sort {
    public static void main(String[] args){
         int[] arr = {13, 46, 24, 52, 20, 9};

        // Print array before sorting
        System.out.println("Before selection sort:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        Solution sol = new Solution();
        // Call selection sort
        sol.SelectionSort(arr);
        System.out.println("After selection sort:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
