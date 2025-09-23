// Problem Statement: Given an integer N, return all divisors of N.

// A divisor of an integer N is a positive integer that divides N without leaving a remainder. In other words, if N is divisible by another integer without any remainder, then that integer is considered a divisor of N.
//  Example 1:
//                 Input:N = 36
               
//                 Output:[1, 2, 3, 4, 6, 9, 12, 18, 36]

import java.util.ArrayList;

public class All_Divisors {
    public static ArrayList<Integer> All_Divisors(int n){
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0){
                divisors.add(i);
            }
        }
        return divisors;
    }
    // Better Solution 
    public static ArrayList<Integer> All_DivisorsBetter(int n){
        ArrayList<Integer> sol = new ArrayList<>();
        int sq = (int)Math.sqrt(n);
        for(int i = 1 ; i < sq ; i++){
            if(n%i == 0) sol.add(i);
            if(n / i != i){
                sol.add(n/i);
            }
        }
        return sol;
    }
    public static void main(String[] args){
        int n = 36;
        System.out.print(All_DivisorsBetter(n));
    }
}
