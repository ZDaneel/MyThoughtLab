package stack;

import java.util.Stack;

/**
 * @author leenadz
 * @since 2025-03-25 14:18
 */
public class IsValid {

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        System.out.println(isValid.isValid(s1));
        System.out.println(isValid.isValid(s2));
        System.out.println(isValid.isValid(s3));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            if (isPair(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    private boolean isPair(char left, char right) {
        return switch (left) {
            case '(' -> right == ')';
            case '{' -> right == '}';
            case '[' -> right == ']';
            default -> false;
        };
    }
}
