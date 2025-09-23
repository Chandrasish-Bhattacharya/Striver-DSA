// Problem Statement: Given an integer N, return true if it is a palindrome else return false.

// A palindrome is a number that reads the same backward as forward. For example, 121, 1331, and 4554 are palindromes because they remain the same when their digits are reversed.

public class Check_Palindrome {
    public static boolean isPalindrome(int n){
        int og = n;
        int rev = 0;
        while(n > 0){
            int last_Digit = n % 10;
            rev = (rev * 10) + last_Digit;
            n = n / 10;
        }
        
        return og == rev;
    }
    public static void main(String[] args){
        int n = 121;
        System.out.print(isPalindrome(n));
    }
}
