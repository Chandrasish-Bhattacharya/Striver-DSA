// Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

// Example 1:
// Input Format: N = 5, array[] = {1,2,4,5}
// Result: 3
// Explanation: In the given array, number 3 is missing. So, 3 is the answer.

// Example 2:
// Input Format: N = 3, array[] = {1,3}
// Result: 2
// Explanation: In the given array, number 2 is missing. So, 2 is the answer.
import java.util.Arrays;
public class Missing_number_in_an_array {
    public static int bruteForceME(int[] array){ // does not work for all test case 
        for(int i = 0; i < array.length - 1; i++) {
    if(array[i+1] - array[i] != 1) {
        return array[i] + 1;
    }
}
        return -1;
    }
    public static int missingNumber(int []a, int N) {

        int hash[] = new int[N + 1]; //hash array

        // storing the frequencies:
        for (int i = 0; i < N - 1; i++)
            hash[a[i]]++;

        //checking the freqencies for numbers 1 to N:
        for (int i = 1; i <= N; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array =  {0,1};
        System.out.print(bruteForceME(array));
        // System.out.print(missingNumber(array,array.length));
    }
}
