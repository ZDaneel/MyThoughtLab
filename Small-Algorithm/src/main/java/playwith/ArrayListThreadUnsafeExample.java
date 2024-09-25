package playwith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author leenadz
 * @since 2024-09-24 14:54
 */
public class ArrayListThreadUnsafeExample {
    private static final int NUM_THREADS = 10;
    private static final int NUM_ITERATIONS = 1000;
    private static MyArrayList sharedList = new MyArrayList();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        // 创建并启动多个线程，同时向 sharedList 中添加元素
//        new CopyOnWriteArrayList<>()
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < NUM_ITERATIONS; j++) {
                    sharedList.add(j);
                }
            });
            threads[i].start();
        }

        // 等待所有线程执行完毕
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("List size: " + sharedList.size());
        // 预期结果应该是 NUM_THREADS * NUM_ITERATIONS，但实际结果可能小于预期值
    }
}
