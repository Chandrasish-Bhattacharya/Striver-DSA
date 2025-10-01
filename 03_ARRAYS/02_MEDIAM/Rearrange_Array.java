// Rearrange Array Elements by Sign

// Problem Statement:
// There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.
// Note: Start the array with positive elements.
// Examples: 
// Example 1:
// Input:
// arr[] = {1,2,-4,-5}, N = 4
// Output:
// 1 -4 2 -5
// Explanation: 
// Positive elements = 1,2
// Negative elements = -4,-5
// To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.
// Example 2:
// Input:
// arr[] = {1,2,3,-1,-2,-3}, N = 6
// Output:
// 1 -3 2 -1 3 -2
// Explanation: 
// Positive elements = 1,2,3
// Negative elements = -3,-1,-2
// To maintain relative ordering, 1 must occur before 2, and 2 must occur before 3.
// Also, -3 should come before -1, and -1 should come before -2.


import java.util.ArrayList;

public class Rearrange_Array {
    static int[] sol1(int[] arr){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i]>=0) pos.add(arr[i]);
            else neg.add(arr[i]);
        }
        for(int i = 0 ; i<pos.size() ; i++){
            arr[2*i] = pos.get(i);
            arr[2*i + 1] = neg.get(i);

        }
        return arr;
    }

    static int[] sol2(int[] arr){ // Optiamal for varient 1 
        int[] ans = new int[arr.length];
        int pos = 0 , neg = 1;
        int j = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]<0){
                ans[neg] = arr[i];
                neg += 2;
            }
            else{
                ans[pos] = arr[i];
                pos += 2; 
            }
        }
        return ans;
    }

     public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
        
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }

        if (pos.size() < neg.size()) {

            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Rearrange_Array sol = new Rearrange_Array();
        int[] arr = {1,2,3,-1,-2,-3};
        int[] solArr = sol.sol2(arr);
        for(int i : solArr){
            System.out.print(i + " ");
        }
    }
}
