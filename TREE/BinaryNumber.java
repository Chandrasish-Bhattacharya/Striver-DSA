import java.util.ArrayList;
import java.util.Stack;

public class BinaryNumber {
    class Solution{
        public ArrayList<Integer> DecimalToBinary(int n){
            Stack<Integer> stack = new Stack<>();
            while(n > 1 | n > 0){
                stack.push(n % 2);
                n = n / 2;
            }
            ArrayList<Integer> result = new ArrayList<>();
            while(!stack.isEmpty()){
                result.add(stack.pop());
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Solution sol = new BinaryNumber().new Solution();
        int n = 10;
        ArrayList<Integer> binaryRepresentation = sol.DecimalToBinary(n);
        System.out.println("Binary representation of " + n + " is: " + binaryRepresentation);

    }
}
