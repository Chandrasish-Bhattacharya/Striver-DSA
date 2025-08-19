import java.util.*;
public class fibonacciTabulation{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to find its Fibonacci value:");
        int n = scanner.nextInt();
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(n+1 , -1));
        int prev2 = 0;
        int prev1 = 1;
        for(int i = 2 ; i<= n ; i++){
            // `dp.set(i, prev1 + prev2);` is updating the value at index `i` in the ArrayList `dp`
            // with the sum of the previous two Fibonacci numbers (`prev1` and `prev2`). This step is
            // part of the tabulation approach for calculating Fibonacci numbers, where the Fibonacci
            // sequence is calculated iteratively by storing the values in an array (or ArrayList in
            // this case) to avoid redundant calculations.
            dp.set(i , prev1 + prev2);
            prev2 = prev1;
            prev1 = dp.get(i);
        }
        System.out.println("Fibonacci no : " + prev1);
    }
}