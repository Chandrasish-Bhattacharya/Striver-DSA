// Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.
// Example 1:
// Input:
//  N = 6, array[] = {9, -3, 3, -1, 6, -5}  
// Result:
//  5  
// Explanation:
//  The following subarrays sum to zero:
// - {-3, 3}
// - {-1, 6, -5}
// - {-3, 3, -1, 6, -5}
// The length of the longest subarray with sum zero is 5.

// Example 2:
// Input:
//  N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}  
// Result:
//  8  
// Explanation:
//  Subarrays with sum zero:
// - {-2, 2}
// - {-8, 1, 7}
// - {-2, 2, -8, 1, 7}
// - {6, -2, 2, -8, 1, 7, 4, -10}
// The length of the longest subarray with sum zero is 8.
import java.util.HashMap;

public class NoSubarraywithzeroSum {
    public static int mysol(int N , int[] nums){
        int maxLength = 0;
        for(int i = 0 ; i < N ; i++){
            int sum = nums[i];
            for(int j = i + 1 ; j < N ; j++){
                sum += nums[j];
                if(sum == 0){
                    maxLength = Math.max(maxLength, j - i );
                }
            }
        }
        return maxLength + 1;
    }

    public static int StriversSol(int N , int[] nums){
        
        HashMap<Integer , Integer> mpp = new HashMap<>();
        int maxi = 0; 
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            sum += nums[i];
            if(sum == 0){
                maxi = i + 1;
            } else{
                if(mpp.get(sum) != null){
                    maxi = Math.max(maxi , i - mpp.get(sum));
                }
                else{
                    mpp.put(sum , i);
                }
            }
        }
        return maxi;
    }
    public static void main(String[] args){
        int[] nums = {6, -2, 2, -8, 1, 7, 4, -10};
        int N = nums.length;
        System.out.println(StriversSol(N, nums));
    }
}
