// Problem Statement: Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array
// Examples

// Example 1:
// Input:
//  arr = [4, 7, 1, 0]
// Output:
//  7 1 0
// Explanation:
//  Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.

// Example 2:
// Input:
//  arr = [10, 22, 12, 3, 0, 6]
// Output:
//  22 12 6
// Explanation:
//  6 is a leader. In addition to that, 12 is greater than all the elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.

import java.util.ArrayList;
import java.util.Collections;

public class Leaders_in_an_Array {
    public static ArrayList mySol(int[] arr , int n){ // this is a brute force this will need n^2 time complexity
        ArrayList<Integer> ans = new ArrayList<>();
        int longest = -1;
        for(int i = 0 ; i<n;i++){
            longest = arr[i];
            for(int j = i+1 ; j<n ; j++){
                if(arr[j] > longest){
                    longest = -1;
                    break;
                }
            }
            if(longest == arr[i]) {
                ans.add(longest);
            }
        }
        return ans;
    }

    public static ArrayList optimalSol(int[] arr){ // optimal sol
        int n = arr.length;
        ArrayList<Integer> sol = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = n - 1; i>0;i--){
            if(arr[i]>max){
                max = arr[i];
                sol.add(max);
            }
        }
        Collections.reverse(sol);
        return sol;
    }
    public static void main(String[] args) {
        // int n = 6;
        int arr[] = { 10, 22, 12, 3, 0, 6 };

        ArrayList<Integer> ans = optimalSol(arr);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
