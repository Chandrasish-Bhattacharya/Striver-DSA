// Problem Statement: Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1..
// Example 1:
// Input: heights = [2, 1, 3, 5, 4]
// Output: 2
// Explanation: One possible route can be,
// 0th step -> 2nd Step = abs(2 - 3) = 1
// 2nd step -> 4th step = abs(3 - 4) = 1
// Total = 1 + 1 = 2.

// Example 2:
// Input: heights = [7, 5, 1, 2, 6]
// Output: 9
// Explanation: One possible route can be,
// 0th step -> 1st Step = abs(7 - 5) = 2
// 1st step -> 3rd step = abs(5 - 2) = 3
// 3rd step -> 4th step = abs(2 - 6) = 4
// Total = 2 + 3 + 4 = 9.

import java.util.Arrays;
import java.util.Scanner;

public class FoxJump {
    public int solution(int[] arr , int n){ // this is the basic recursion one
        if(n == 0){
            return 0;
        }
        int Onestep = solution(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);
        int Twostep = Integer.MAX_VALUE;
        if( n > 1){
            Twostep = solution(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);
        }
        return Math.min(Onestep , Twostep);
    }
    public int Memoization(int[] arr, int n , int[] dp){
        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int Onestep = solution(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);
        int Twostep = Integer.MAX_VALUE;
        if( n > 1){
            Twostep = solution(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);
        }
        return dp[n] = Math.min(Onestep , Twostep);
    }
    public int tabulation(int[] arr, int[] dp){
        dp[0] = 0;
        for(int i = 1 ; i < arr.length ; i++){
            int Onestep = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int Twostep = Integer.MAX_VALUE;
            if(i > 1){
                Twostep = dp[ i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(Onestep , Twostep);
        }
        return dp[arr.length - 2];
    }
    public int bestSol(int[] arr){
        int prev = 0;
        int prev2 = 0;
        for(int i = 1 ; i < arr.length ; i++){
            int OneStep = prev + Math.abs(arr[i] - arr[i - 1]);

            int TwoStep = Integer.MAX_VALUE;
            if(i > 1){
                TwoStep = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }
            int curr = Math.min(OneStep , TwoStep);
            prev2 = prev;
            prev = curr;
        }
        return  prev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim().replaceAll("[\\[\\](){}<>]", " ");
        String[] parseStrings = s.split("[,\\s]+");

        int[] arr = new int[parseStrings.length];
        int index = 0;

        for (String str : parseStrings) {
            if (!str.isEmpty()) {
                arr[index++] = Integer.parseInt(str);
            }
        }
        int[] dp = new int[index + 1];
        Arrays.fill(dp,-1);
        FoxJump sol = new FoxJump();
        System.out.print(sol.Memoization(arr, index - 1 , dp));
        sc.close();
    }
}
