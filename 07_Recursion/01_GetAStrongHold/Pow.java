// Implement Pow(x,n) | X raised to the power N
// Problem Statement: Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).
// Examples:
// Example 1:
// Input: x = 2.00000, n = 10
// Output: 1024.00000
// Explanation: You need to calculate 2.00000 raised to 10 which gives ans 1024.00000
// Example 2:
// Input: x = 2.10000, n = 3
// Output: 9.26100
// Explanation: You need to calculate 2.10000 raised to 3 which gives ans 9.26100

import java.util.Scanner;

public class Pow {
    public static double powIterative(double x, int n) {
        double ans = 1.0;
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        return ans;
    }

    // Now lets Implement the best approach binary exponenet:
    public static double powBest(double x, int n) {
        double ans = 1.0;
        int binaryForm = n;
        if (n < 0) {
            binaryForm = -1 * binaryForm;
        }
        while (binaryForm > 0) { // basically coverting the n to binary
            if (binaryForm % 2 == 1) {
                ans *= x;
            }
            binaryForm = binaryForm / 2;
            x *= x;
        }
        if (n < 0)
            return (double) (1.0) / (double) (ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no : ");
        double x = sc.nextInt();
        System.out.println("Enter the power : ");
        int n = sc.nextInt();
        sc.close();
        System.out.println(powBest(x, n));
    }
}
