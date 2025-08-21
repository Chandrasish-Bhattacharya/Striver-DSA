
import java.util.Arrays;
import java.lang.Math;

public class Frogjump {

    public static int frog(int idx, int a[], int dp[]) {
        if (idx == 0) {
            return 1;
        }
        if (idx == 1) {
            return Math.abs(a[1] - a[0]);
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int jump1 = frog(idx - 1, a, dp) + Math.abs(a[idx] - a[idx - 1]);
        int jump2 = Integer.MAX_VALUE;
        if (idx > 1) {
            jump2 = frog(idx - 2, a, dp) + Math.abs(a[idx] - a[idx - 2]);
        }
        return dp[idx] = Math.min(jump1, jump2);
    }

    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        int[] a = {10, 20, 30, 10};
        Arrays.fill(dp, -1);
        System.out.println(frog(n - 1, a, dp));

    }
}
