// Example 1:
// Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]
// Output: 210
// Explanation:
// Day 1: fighting practice = 70
// Day 2: stealth training = 50
// Day 3: fighting practice = 90
// Total = 70 + 50 + 90 = 210
// This gives the optimal points.

// Example 2:
// Input: matrix = [[70, 40, 10], [180, 20, 5], [200, 60, 30]]
// Output: 290 
// Explanation:
// Day 1: running = 70
// Day 2: stealth training = 20
// Day 3: running = 200
// Total = 70 + 20 + 200 = 290
// This gives the optimal points.
import java.util.Arrays;
import java.util.Scanner;

public class NinjaTraining {

    public int Recursion(int[][] arr, int row, int last) {
        if (row == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int points = arr[row][i] + Recursion(arr, row - 1, i);
                maxi = Math.max(maxi, points);
            }
        }
        return maxi;
    }

    public int Memoisation(int[][] arr, int row, int last, int[][] dp) {
        if (row == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }
        if (dp[row][last] != -1) {
            return dp[row][last];
        }
        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int points = arr[row][i] + Memoisation(arr, row - 1, i, dp);
                maxi = Math.max(maxi, points);
            }
        }
        return dp[row][last] = maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().trim()
                .replace("[[", "")
                .replace("]]", "")
                .replace("], [", "|");

        String[] rows = input.split("\\|");

        int[][] arr = new int[rows.length][3];

        for (int i = 0; i < rows.length; i++) {
            String[] nums = rows[i].split(", ");
            for (int j = 0; j < nums.length; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }

        NinjaTraining sol = new NinjaTraining();
        int dp[][] = new int[arr.length + 1][4];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(sol.Memoisation(arr, arr.length - 1, 3, dp));

        sc.close();
    }
}