
import java.util.Arrays;

public class MAXIMUM_SUM_NON_ADJACENT_ELEMENT {

    public static int f(int x, int[] a) {  // recursion
        if (x == 0) {
            return a[x];
        }
        if (x < 0) {
            return 0;
        }
        int pick = a[x] + f(x - 2, a);
        int not_pick = f(x - 1, a);
        return Math.max(pick, not_pick);
    }

    public static int FM(int x, int[] a, int[] dp) { // Memoization
        if (x == 0) {
            return a[x];
        }
        if (x < 0) {
            return 0;
        }
        if (dp[x] != -1) {
            return dp[x];
        }
        int pick = a[x] + f(x - 2, a);
        int not_pick = f(x - 1, a);
        dp[x] = Math.max(pick, not_pick);
        return dp[x];
    }

    public static int FT(int x, int[] a, int[] dp) { // Memoization

        dp[0] = a[0];
        if (a.length > 1) {
            dp[1] = Math.max(a[0], a[1]);
        }

        for (int i = 2; i < a.length; i++) {
            int take = a[i] + dp[i - 2]; // take current and skip one before
            int nontake = dp[i - 1];     // skip current
            dp[i] = Math.max(take, nontake);
        }

        return dp[a.length - 1]; // final result

    }

    public static void main(String[] args) {

        int[] a = {3, 2, 5, 10, 7}; // Example array
        int[] dp = new int[a.length];
        Arrays.fill(dp, -1);
        int n = a.length;
        // int result = f(n - 1,a);
        // int result =FM(n - 1 , a , dp);
        int result = FT(n - 1, a, dp);
        System.out.println("Maximum sum of non-adjacent elements: " + result);
    }

}
