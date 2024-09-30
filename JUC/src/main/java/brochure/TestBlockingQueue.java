package brochure;

import java.util.LinkedList;

/**
 * @author leenadz
 * @since 2024-09-29 16:14
 */
public class TestBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new BlockingQueue<>(1);

        // 生产者
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.put("消息" + i);
            }
        }, "生产者1").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.put("消息" + i);
            }
        }, "生产者2").start();

        // 消费者
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.take();
            }
        }, "消费者1").start();
    }
}

class BlockingQueue<T> {
    private final LinkedList<T> queue = new LinkedList<>();
    private int MAX_SIZE = 1;
    private  int remainCount = 0;
    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.MAX_SIZE = capacity;
    }

    public synchronized void put(T resource) {
        // 使用while循环，防止虚假唤醒
        while (queue.size() >= MAX_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName());
        queue.addFirst(resource);
        remainCount++;
        printMsg(resource, "入队");
        this.notifyAll();
    }

    public synchronized void take() {
        while (queue.size() <= 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName());
        T resource = queue.removeLast();
        remainCount--;
        printMsg(resource, "出队");
        this.notifyAll();
    };

    private void printMsg(T resource, String operation) {
        System.out.println(resource + operation);
        System.out.println("队列容量：" + remainCount);
    }
}