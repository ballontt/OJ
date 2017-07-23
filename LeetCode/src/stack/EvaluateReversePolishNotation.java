package stack;

import java.util.Stack;

/**
 * Created by ballontt on 2017/6/25.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int op1 = 0;
        int op2 = 0;
        for(int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.add(op1 + op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.add(op1 - op2);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.add(op1 * op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.add(op1 / op2);
                    break;
                    default:
                        stack.add(Integer.valueOf(tokens[i]));
                        break;
            }
        }
        result = stack.pop();
        return result;
    }
}
