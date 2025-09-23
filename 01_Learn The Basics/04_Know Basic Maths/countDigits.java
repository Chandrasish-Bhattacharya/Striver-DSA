// Count digits in a number
// Problem Statement: Given an integer N, return the number of digits in N.
// Example 1:
// Input Format: N = 12345
// Result: 5
// Explanation: In the given number, there are 5 digits. So, 5 is the answer.
public class countDigits{
    public static int countDigits(int n){
        int count = 0;
        while(n > 0){
            n = n /10;
            count++;
        }
        return count;
    }
    
    // A better approach is to use logarithm
    public static int countDigitsLog(int n){
        return (int)(Math.log10(n)) + 1;
    }

    public static void main(String[] args){
        int n = 12345;
        System.out.print(countDigitsLog(n));
    }
}