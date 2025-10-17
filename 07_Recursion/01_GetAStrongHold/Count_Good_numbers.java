// Count Good numbers
// Problem Statement: A digit string is considered good if the digits at even indices (0-based) are even digits (0, 2, 4, 6, 8) and the digits at odd indices are prime digits (2, 3, 5, 7).
// Given an integer n, return the total number of good digit strings of length n. As the result may be large, return it modulo 109 + 7.
// A digit string is a string consisting only of the digits '0' through '9'. It may contain leading zeros.
// Example 1:
// Input: n = 1
// Output: 5
// Explanation: Only one index (0) → must be even.
// Valid strings: "0", "2", "4", "6", "8"

// Example 2:
// Input: n = 2
// Output: 20
// Explanation: Index 0: 5 options (even digits)
// Index 1: 4 options (prime digits)
// Total: 5 * 4 = 20
public class Count_Good_numbers {
    // so basically there are 5 even no's and 4 odd no's
    // so the brute force:
    public static int brute(int n) { // this will lead to tle an the no can be too long
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                ans *= 5;
            else
                ans *= 4;
        }
        return ans;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = 2;
        sc.close();
        System.out.println(brute(n));
    }
}
