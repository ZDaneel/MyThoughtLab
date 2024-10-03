package brochure.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * @author leenadz
 * @since 2024-10-01 21:12
 */
public class TestExecutor {
    public static void main(String[] args) {

        ThreadExecutorTest simpleThreadPool = new ThreadExecutorTest(2, new ArrayBlockingQueue<Runnable>(2));

        simpleThreadPool.execute(() -> {
            System.out.println("第1个任务开始");
            sleep(3);
            System.out.println("第1个任务结束");
        });
        simpleThreadPool.execute(() -> {
            System.out.println("第2个任务开始");
            sleep(4);
            System.out.println("第2个任务结束");
        });
        simpleThreadPool.execute(() -> {
            System.out.println("第3个任务开始");
            sleep(5);
            System.out.println("第3个任务结束");
        });
    }


    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
