import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int CountRevenueWindows(int[] revenue, int k, int n) { // lets code the brute force first
        int sum = Integer.MIN_VALUE;
        int count_subarray = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += revenue[j];
                if (sum == k)
                    count_subarray = count_subarray + 1;

            }
        }
        return count_subarray;
    }

    public int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        HashMap <Integer , Integer>  mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}

public class Delivery_Analyst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // taking the array size
        int k = sc.nextInt(); // taking the array size
        sc.nextLine();
        int[] revenue = new int[n];
        // taking the array input:
        for (int i = 0; i < n; i++) {
            revenue[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        int noOfSubArray = sol.findAllSubarraysWithGivenSum(revenue, k);
        System.out.println(noOfSubArray);
        sc.close();
    }
}