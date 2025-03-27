package stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leenadz
 * @since 2025-03-25 14:00
 */
public class MyStack {

    Queue<Integer> queue;
    Queue<Integer> queueBackup;

    public MyStack() {
        queue = new LinkedList<>();
        queueBackup = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        while (queue.size() > 1) {
            queueBackup.add(queue.remove());
        }
        Integer res = queue.remove();
        while (!queueBackup.isEmpty()) {
            queue.add(queueBackup.remove());
        }
        return res;
    }

    public int top() {
        while (queue.size() > 1) {
            queueBackup.add(queue.remove());
        }
        Integer res = queue.peek();
        queueBackup.add(queue.remove());
        while (!queueBackup.isEmpty()) {
            queue.add(queueBackup.remove());
        }
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
