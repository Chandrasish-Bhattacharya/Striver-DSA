// Given an array of integers: [1, 2, 1, 3, 2] and we are given some queries: [1, 3, 4, 2, 10]. 
// For each query, we need to find out how many times the number appears in the array. 
//For example, if the query is 1 our answer would be 2, and if the query is 4 the answer will be 0. 

import java.util.Scanner;

public class Hashing {
// lets first write the brute force and then we will be optimizing this 
    public int No_OFF_Times(int num , int arr[]){
        int count = 0;
        for(int i : arr){
            if(num == i){
                count++;
            }
        }
        return count;
    }
    // Optimal 
    public int[] no_Times(int arr[]){
        int[] hash = new int[13];
        for(int i = 0 ; i<arr.length ; i++){
            hash[arr[i]] +=1;
        }
        return hash;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 1, 3, 2};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]search_for = new int[n];
        for(int i = 0 ; i<n ; i++){
            search_for[i] = sc.nextInt();
        }
        Hashing s = new Hashing();
        int[] Hash = s.no_Times(arr);
        for(int i = 0 ; i<n ; i++){
            System.out.print(Hash[search_for[i]]+ " ");
        }
        
        // for(int i = 0 ; i<n ; i++){
        //     System.out.println(s.No_OFF_Times(search_for[i],arr)); 
        // }

    }
}
