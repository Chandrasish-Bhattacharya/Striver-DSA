import java.util.Arrays;
import java.util.Scanner;

public class Fibonarchi{
    public int NormalSol(int n){
        if(n <= 1){
            return n;
        }
        return NormalSol(n - 1) + NormalSol(n - 2);
    }
    public int Memoization(int n , int[] dp){
        if(n <= 1 ){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = Memoization(n - 1, dp) + Memoization(n - 2, dp);
        
    }
    public int tabulation(int n , int[] dp){
        dp[0] = 0 ; dp [1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        } 
        return dp[n];
    }
    public int bestSol(int n){
        if(n <= 1) return n;
        int prev = 0 , curr = 1 , tail;
        for(int i = 2 ; i <= n ; i++){
            tail = curr + prev;
            prev = curr;
            curr = tail;
        }
        return curr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Fibonarchi sol = new Fibonarchi();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        System.out.print(sol.bestSol(n));
        sc.close();
    }
}