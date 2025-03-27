package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author leenadz
 * @since 2025-03-26 13:07
 */
public class EvalRPN {

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};


        System.out.println(9 == evalRPN.evalRPN(tokens1));
        System.out.println(6 == evalRPN.evalRPN(tokens2));
        System.out.println(22 == evalRPN.evalRPN(tokens3));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            switch (s) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> stack.push(-stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp2 / temp1);
                }
                case null, default -> stack.push(Integer.valueOf(Objects.requireNonNull(s)));
            }
        }
        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isOper(token)) {
                String operator2 = stack.pop();
                String operator1 = stack.pop();
                stack.push(String.valueOf(evalOperation(token, operator1, operator2)));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private int evalOperation(String oper, String operator1, String operator2) {
        return switch (oper) {
            case "+" -> Integer.parseInt(operator1) + Integer.parseInt(operator2);
            case "-" -> Integer.parseInt(operator1) - Integer.parseInt(operator2);
            case "*" -> Integer.parseInt(operator1) * Integer.parseInt(operator2);
            case null, default -> Integer.parseInt(operator1) / Integer.parseInt(operator2);
        };
    }

    private boolean isOper(String token) {
        return ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
