import java.util.ArrayList;
import java.util.Scanner;
public class fibonacciMemoization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to find its Fibonacci value:");
        int n = scanner.nextInt();
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(-1);
        }
        int result = fibonacci(n, dp);
        System.out.println("Fibonacci value: " + result);
    }

    public static int fibonacci(int n , ArrayList<Integer> dp) {
        if (n <= 1) 
            return n;
        if (dp.get(n) != -1) 
            return dp.get(n);
        return fibonacci(n - 1 , dp) + fibonacci(n - 2 , dp);
    }
}