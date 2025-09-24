// Find the number that appears once, and the other numbers twice
// Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.
// Example 1:
// Input Format: arr[] = {2,2,1}
// Result: 1
// Explanation: In this array, only the element 1 appear once and so it is the answer.
// Example 2:
// Input Format: arr[] = {4,1,2,1,2}
// Result: 4
// Explanation: In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.

public class Single{
    public static int SingleElement_BrutteForce(int arr[]){
         // Size of the array:
        int n = arr.length;

        //Run a loop for selecting elements:
        for (int i = 0; i < n; i++) {
            int num = arr[i]; // selected element
            int cnt = 0;

            //find the occurrence using linear search:
            for (int j = 0; j < n; j++) {
                if (arr[j] == num)
                    cnt++;
            }

            // if the occurrence is 1 return ans:
            if (cnt == 1) return num;
        }

        //This line will never execute
        //if the array contains a single element.
        return -1;
    }
    // Better Solution 
    public static int Better(int[] arr){
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            max = Math.max(arr[i] , max);
        }
        int[] hash = new int[max + 1];
        for(int i = 0 ; i < arr.length ; i++){
            hash[arr[i]]++;
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(hash[arr[i]] == 1){
                return arr[i];
            }
        }
        return -1;
    }

    
    // Optimal Solution
    public static int optimal(int arr[]){
        int xor = 0;
        for(int i : arr){
            xor = xor^i;
        }
        return xor;
    }

    public static void main(String[] args){
        int[] arr = {2,2,3,1,1};
        System.out.print(optimal(arr));

    }
}