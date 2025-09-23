// Check if a number is Armstrong Number or not
// Problem Statement: Given an integer N, return true it is an Armstrong number otherwise return false.

// An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.

// Example 1:
// Input:N = 153
// Output:True
// Explanation: 13+53+33 = 1 + 125 + 27 = 153

public class Amrstrong_Number{
    public static boolean checkAmrstrong(int n){
        int og = n;
        int arm = 0;
        while(n>0){
            int last = n%10;
            arm = arm + (last*last*last);
            n = n/10;
        }
        if(arm == og) return true;
        return false;
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println(checkAmrstrong(n));
    }
}