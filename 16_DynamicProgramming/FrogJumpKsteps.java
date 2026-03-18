// Frog Jump with k Distances
// A frog wants to climb a staircase with n steps. 
// Given an integer array heights, where heights[i] contains the height of the ith step, and an integer k. To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from the ith step to any step in the range [i + 1, i + k], provided it exists. 
// Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
// Example 1:
// Input: heights = [10, 5, 20, 0, 15], k = 2
// Output: 15
// Explanation:
// 0th step -> 2nd step, cost = abs(10 - 20) = 10
// 2nd step -> 4th step, cost = abs(20 - 15) = 5
// Total cost = 10 + 5 = 15.

// Example 2:
// Input: heights = [15, 4, 1, 14, 15], k = 3
// Output: 2
// Explanation:
// 0th step -> 3rd step, cost = abs(15 - 14) = 1
// 3rd step -> 4th step, cost = abs(14 - 15) = 1
// Total cost = 1 + 1 = 2.
import java.util.Arrays;
import java.util.Scanner;

public class FrogJumpKsteps {
    public int TotalCostUsingRecursion(int[] height, int idx, int k) {
        if (idx == 0) {
            return 0;
        }
        int minStep = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = TotalCostUsingRecursion(height, idx - i, k) + Math.abs(height[idx] - height[idx - i]);
                minStep = Math.min(minStep, jump);
            }
        }
        return minStep;
    }
    public int Memoization(int[] height , int idx , int k , int[] dp){
        if(idx == 0) return 0;

        if(dp[idx] != -1){
            return dp[idx];
        }
        int minStep = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = Memoization(height, idx - i, k,dp) + Math.abs(height[idx] - height[idx - i]);
                minStep = Math.min(minStep, jump);
            }
        }
        return dp[idx] = minStep;
    }
    public int tabulation(int[] height , int k){
        int[] dp = new int[height.length];
        dp[0] = 0;
        for(int i = 1 ; i < height.length ; i++){
            int minStep = Integer.MAX_VALUE;

            for(int j = 1 ; j <= k ; j++){
                if(i - j >= 0){
                    int jump = dp[i - j]  + Math.abs(height[i] - height[i - j]);
                    minStep = Math.min(minStep , jump);
                }
            }
            dp[i] = minStep;
        }
        return dp[height.length - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim().replaceAll("[\\[\\]{}()<>]", " ");
        String[] parseArr = s.split("[,\\s]+");

        int count = 0;
        for (String str : parseArr) {
            if (!str.isEmpty())
                count++;
        }

        int[] arr = new int[count];
        int index = 0;

        for (String str : parseArr) {
            if (!str.isEmpty()) {
                arr[index++] = Integer.parseInt(str);
            }
        }
        FrogJumpKsteps sol = new FrogJumpKsteps();
        int[] dp = new int[count + 1]; 
        Arrays.fill(dp,-1);
        System.out.print(sol.tabulation(arr, 2));
        sc.close();
    }
}
