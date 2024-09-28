package atguigu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author leenadz
 * @since 2024-09-28 19:39
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        try (ExecutorService pool = Executors.newFixedThreadPool(5)) {
            // pool.submit(threadPoolDemo);
            List<Future<String>> futureList = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                Future<String> future = pool.submit(() -> {
                    return Thread.currentThread().getName();
                });
                futureList.add(future);
            }
            for (Future<String> future : futureList) {
                System.out.println(future.get());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ThreadPoolDemo implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (i <= 20) {
            System.out.println(Thread.currentThread().getName() + " : " + i++);
        }
    }
}
