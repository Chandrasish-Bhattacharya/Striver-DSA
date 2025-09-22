// Given an array of integers, rotating array of elements by k elements either left or right.
// Example 1:
// Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
// Output: 6 7 1 2 3 4 5
// Explanation: array is rotated to right by 2 position

// lets go 

import java.util.Scanner;

public class Rotate_array_by_K_elements{
    public static int[] solution(int[] arr,int n ,int k){
        // if k = n then there is no need of shifting the array element
        // if the value of n = k + 1 that means we just have to shift the element by one place
        if(n == 0){
            return arr;
        }
        k = k % n;
        // so what I am going do for the brute force approach 
        // we can simply take a temp array and put the values the temp index and then put them back to the places 
        int[] temp = new int[k];
        for(int i = 0 ; i<k ; i++){
            temp[i] = arr[i];
        }
        // now lets move the value to the place 
        for(int i = k ; i<n ; i++){
            arr[i-k] = arr[i]; // suppose k = 3 so a[0] will hold the value of a[3] which means i = 3 now 
            // i - k = 3 - 3 so the 3 index is moved to the 0 place 
        }
        for(int i = n-k ; i<n ; i++){
            arr[i] = temp[i-(n-k)];
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7};
        int sol[] = solution(arr, arr.length , 5);
        for(int i : sol){
            System.out.print(i + " ");
        }
    }
}