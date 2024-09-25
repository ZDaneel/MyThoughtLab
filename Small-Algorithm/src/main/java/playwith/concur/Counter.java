package playwith.concur;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leenadz
 * @since 2024-09-24 15:22
 */
public class Counter {
    private int count;
    private final Lock lock = new ReentrantLock();
    private static final int NUM_THREADS = 10;

//    public void add(int n) {
//        synchronized(this) {
//            count += n;
//        }
//    }

//    public synchronized void add(int n) {
//        count += n;
//    }

    public void add(int n) {
        lock.lock(); // 获取锁
        try {
            count += n;
        } finally {
            lock.unlock(); // 释放锁
        }
    }


    public static void main(String[] args) {
        // 创建多线程访问计数器
        Counter counter = new Counter();
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.add(1);
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Count: " + counter.count);
    }
}
