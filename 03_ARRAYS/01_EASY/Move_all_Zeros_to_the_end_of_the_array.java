// Move all Zeros to the end of the array
// Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.

public class Move_all_Zeros_to_the_end_of_the_array {
    // Brute Force 
    public static int[] bruteForce(int arr[]){
        int count = 0;
        int push[] = new int[arr.length];
        int j = 0;
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] == 0){
                count++;
            }
            else{
                push[j] = arr[i];
                j++;
            }
        }
        for(int i = j ; i<count ; i++){
            push[i] = 0;
        }
        return push;
    }

    // Best Solution
    public static int[] better(int[] a){ // this code just reduce the space complexity 
        int j = -1;
        int n = a.length;
        //place the pointer j:
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                j = i;//just initallizing the value of j for the first time
                break;
            }
        }
        // if there is no zero element the 
        //no non-zero elements:
        if (j == -1) return a;

        //Move the pointers i and j
        //and swap accordingly:
        for (int i = j + 1; i < n; i++) {
            if (a[i] != 0) {
                //swap a[i] & a[j]:
                int tmp = a[i]; //swaping the non zero element with the zero element
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }
        return a;
    }
    public static void main(String[] args){
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        // int[] sol = bruteForce(arr);
        int[] sol = better(arr);

        for(int i : sol){
            System.out.print(i + " ");
        }
    }
}
