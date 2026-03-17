import java.util.Scanner;

public class ClimbingStairs {
    public int Recursion(int n ){
        if(n <= 1){
            return n;
        }
        int left = Recursion(n-1); // jumping for 1 step 
        int right = Recursion(n-2); // jumping for 2 step 
        return left + right;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ClimbingStairs sol = new ClimbingStairs();
        System.out.print(sol.Recursion(n));
        sc.close();
    }
}
