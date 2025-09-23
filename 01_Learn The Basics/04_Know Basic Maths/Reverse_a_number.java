// Reverse a number
// You are given an integer n. Return the integer formed by placing the digits of n in reverse order.
// Example 1:
// Input Format: n = 12345
// Result: 54321
public class Reverse_a_number{
    public static int reverse(int n){
        int reverse = 0;
        while(n > 0){
            int last_Digit = n % 10;
            reverse = reverse * 10 + last_Digit;
            n = n / 10;
        }
        return reverse;
    }
    public static void main(String[] args){
        int n = 12345;
        System.out.print(reverse(n));
    }
}