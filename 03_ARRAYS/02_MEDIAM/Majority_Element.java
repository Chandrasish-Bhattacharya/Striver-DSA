// Find the Majority Element that occurs more than N/2 times
// Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

// Example 1:
// Input Format: N = 3, nums[] = {3,2,3}
// Result: 3
// Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

// Example 2:
// Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}

// Result: 2

// Explanation: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

// Example 3:
// Input Format:  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}

import java.util.HashMap;

public class Majority_Element {
    public static int bruteForce(int[] nums){
        int n = nums.length;
        
        for(int i = 0 ; i<n ; i++){
            int count = 0;
            for(int j = 0 ; j<n;j++){
                if(nums[j] == nums[i]){
                    count++;
                }
            }
            if(count>(n/2))
            return nums[i];
        }
        return -1;
    }
    public static int betterSol(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else map.put(nums[i], 1);
        }
        for(HashMap.Entry<Integer,Integer> sol : map.entrySet()){
            if(sol.getValue() > (nums.length)/2){
                return sol.getKey();
            }
        }
        return -1;
    }

    // Optimal Sol
    public static int best(int[] nums){ // Moore’s Voting Algorithm
        int cnt = 0;
        int el = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++ ){
            if(cnt == 0){
                el = nums[i];
                cnt++;
            }
            else if(el == nums[i]) cnt++;
            else cnt--;
        }
        return el; // if it has is sure that there exist a majority element
    }
    public static void main(String[] args){
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(best(arr));
    }
}
