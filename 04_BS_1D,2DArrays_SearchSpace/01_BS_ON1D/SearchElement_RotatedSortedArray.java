// Search Element in a Rotated Sorted Array
// Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k. Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.
// Example 1:
// Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
// Result: 4
// Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.
// Example 2:
// Input Format: arr = [4,5,6,7,0,1,2], k = 3
// Result: -1
// Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.



public class SearchElement_RotatedSortedArray {
    public static int Brute(int[] arr , int k){
        for(int i = 0; i<arr.length ;i++){
            if(arr[i] == k) return i; 
        }
        return -1;
    }
    public static int Optimal(int[] arr , int k){
        int low = 0 , high = arr.length - 1;
        while(low<=high){
            int mid = (high + low) / 2;
            if(arr[mid] == k) return mid;
            // if left is Sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= k && k<= arr[mid]){
                    high = mid - 1;
                }
                else low = mid + 1;
            } else { // if right is Sorted 
                if(arr[mid] <= k && k<= arr[high])
                low = mid + 1;
                else 
                high = mid - 1;
            }
        }
        return -1;
    }

     public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int k = 1;
        int ans = Brute(arr, k);
        if (ans != -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }    
}
