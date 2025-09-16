// Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.
// If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result. It does not matter what you leave beyond the first k elements.

import java.util.HashSet;

public class Remove_DuplicatesInplace {
    // let write a brute force approach
    public static int Solution1(int arr[]){  // this code does not satisfy the in place condition
        int n = arr.length;
        if(n==0 || n==1){
            return arr[n];
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            set.add(arr[i]);
        }
        int k = set.size();
        int idx = 0;
        for(int s : set){
            arr[idx++] = s;
        }
        return k;
    }
    // let's write an optimal approach
    public static int Solution2(int arr[]){
        int n = arr.length;
        if(n==0||n==1) return arr[n];
        // let use a 2 pointer approach 
        int i = 0;
        for(int j = 1; j<n; j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args){
        int arr[] = {1,1,2,2,3,4,4,5,5};
        // int k = Solution1(arr);
        // System.out.println("The array after removing duplicate elements is ");
        // for (int i = 0; i < k; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        
        int k = Solution2(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
