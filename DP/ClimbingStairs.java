// class Solution {
//     public int climbStairs(int n) { // had a TLE
//         int ways1, ways2;
//     if (n <= 1) return 1;
//     if(n == 2) return 2;

//     ways1 = climbStairs(n - 1);
//     ways2 = climbStairs(n - 2);
// return ways1 + ways2;
//     }
// }
import java.util.Arrays;
// lets use meoisation
// public class ClimbingStairs{  // still TLE in Memoization 
//     class Solution{
//         public int climbStairs(int n , int[] dp){
//             if(dp[n] != -1){
//                 return dp[n];
//             }
//             return climbStairs(n -1 ,dp) + climbStairs(n-2,dp);
//         }
//         public int stair(int n){
//             int dp[] = new int[n+1];
//             Arrays.fill(dp,-1);
//             dp[0] = 1;
//             dp[1] = 1;
//             dp[2] = 2;
//             return climbStairs(n, dp);
//         }
//     }
// }

public class ClimbingStairs {  // Tabulation

    class Solution {

        public int climbStairs(int n) {
            if (n <= 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
