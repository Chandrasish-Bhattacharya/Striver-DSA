// Input: nums = [1, 2, 4]
// Output: 5
// Explanation: 
// Subsequence {1,4} gives maximum sum.

// Input:  [2, 1, 4, 9]
// Output: 11
// Explanation: 
// Subsequence {2,9} gives maximum sum
import java.util.Arrays;
import java.util.Scanner;

public class HouseRobber {
    public int BasicRecursion(int[] arr, int idx) {
        if (idx < 0) {
            return 0;
        }
        if (idx == 0) {
            return arr[0];
        }

        int pick = arr[idx] + BasicRecursion(arr, idx - 2);
        int notPick = BasicRecursion(arr, idx - 1);

        return Math.max(pick, notPick);
    }

    public int Memoisation(int[] arr, int idx, int[] dp) {
        if (idx < 0)
            return 0;
        if (idx == 0) {
            return arr[0];
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int pick = arr[idx] + Memoisation(arr, idx - 2, dp);
        int notPick = Memoisation(arr, idx - 1, dp);
        return dp[idx] = Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim().replaceAll("[\\[\\](){}<>]", " ");
        String[] parseString = s.split("[,\\s]+");
        int[] arr = new int[parseString.length];
        int idx = 0;
        for (String str : parseString) {
            if (!str.isEmpty())
                arr[idx++] = Integer.parseInt(str);
        }
        HouseRobber sol = new HouseRobber();
        int[] dp = new int[idx + 1];
        Arrays.fill(dp, -1);
        System.out.print(sol.Memoisation(arr, idx - 1, dp));
        sc.close();
    }
}