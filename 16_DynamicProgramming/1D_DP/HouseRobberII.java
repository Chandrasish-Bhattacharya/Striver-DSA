import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public int tabulation(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }

    public int rob(int[] arr) {
        int n = arr.length;

        // Edge cases
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        // Case 1: Exclude first house
        int[] temp1 = new int[n - 1];
        // Case 2: Exclude last house
        int[] temp2 = new int[n - 1];

        int idx1 = 0, idx2 = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                temp1[idx1++] = arr[i];
            }
            if (i != n - 1) {
                temp2[idx2++] = arr[i];
            }
        }

        return Math.max(tabulation(temp1), tabulation(temp2));
    }
}
public class HouseRobberII {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim().replaceAll("[\\[\\](){}<>]", " ");
        String[] parseString = s.split("[,\\s]+");
        int[] arr = new int[parseString.length];
        int idx = 0;
        for (String str : parseString) {
            if (!str.isEmpty())
                arr[idx++] = Integer.parseInt(str);
        }
        Solution sol = new Solution();
        int[] dp = new int[idx + 1];
        Arrays.fill(dp, -1);
        System.out.print(sol.rob(arr));
        sc.close();
    }
}
