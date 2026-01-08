import java.util.ArrayList;
import java.util.List;

public class binarystrings {
    public static void sol(int n , String s , List<String> result){
        if(s.length() == n){
            result.add(s);
            return;
        }

        sol(n , s + '0' , result);

        if(s.isEmpty() || s.charAt(s.length() - 1) != '1'){
           sol(n , s + '1' , result);
        }
    }


     public static void main(String[] args) {
        // Input length n
        int n = 3;

        // List to store results
        List<String> result = new ArrayList<>();

        // Start recursion with empty string
        sol(n, "", result);

        // Print results
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
