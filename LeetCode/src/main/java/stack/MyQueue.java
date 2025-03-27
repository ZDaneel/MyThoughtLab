package stack;

import java.util.Stack;

/**
 * @author leenadz
 * @since 2025-03-25 12:39
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // returns 1
        System.out.println(queue.pop());  // returns 1
        System.out.println(queue.empty()); // returns false
    }

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        // stack.empty()
        stackIn2Out();
        return stackOut.pop();
    }

    private void stackIn2Out() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public int peek() {
        stackIn2Out();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }
}
