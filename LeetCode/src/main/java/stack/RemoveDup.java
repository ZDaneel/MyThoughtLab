package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author leenadz
 * @since 2025-03-26 12:41
 */
public class RemoveDup {

    public static void main(String[] args) {
        RemoveDup removeDup = new RemoveDup();
        String s = "abbaac";
        System.out.println(removeDup.removeDuplicates(s));
    }

    public String removeDuplicates2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.empty() && cur == stack.peek()) {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }
        char[] resArr = new char[stack.size()];
        for (int i = resArr.length - 1; i >= 0; i--) {
            resArr[i] = stack.pop();
        }
        return new String(resArr);
    }

    //ArrayDeque<Character> deque = new ArrayDeque<>();
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.isEmpty() && cur == stack.peek()) {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }
        char[] resArr = new char[stack.size()];
        for (int i = resArr.length - 1; i >= 0; i--) {
            resArr[i] = stack.pop();
        }
        return new String(resArr);
    }
}
