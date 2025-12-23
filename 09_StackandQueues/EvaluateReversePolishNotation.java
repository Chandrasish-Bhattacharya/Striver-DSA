import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluator = new EvaluateReversePolishNotation();
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(evaluator.evalRPN(tokens)); // Output: 9
    }
}