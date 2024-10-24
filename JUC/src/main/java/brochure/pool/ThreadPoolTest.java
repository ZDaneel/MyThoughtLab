package brochure.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author leenadz
 * @since 2024-10-02 10:39
 */
@Slf4j
public class ThreadPoolTest {

    public static void main(String[] args) {

        // 创建线程池，核心线程1，最大线程2
        // 提交4个任务：第1个任务交给核心线程、第2个任务入队、第3个任务交给非核心线程、第4个任务被拒绝
        //ThreadPoolExecutor
        ThreadPool threadPoolExecutor = new ThreadPool(
                1,
                3,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                (r, executor) -> log.info("任务被拒绝：{}", r)
        );

        threadPoolExecutor.execute(() -> {
            log.info("{}:执行第1个任务...", Thread.currentThread().getName());
            sleep(10);
        });

        sleep(1);

        threadPoolExecutor.execute(() -> {
            log.info("{}:执行第2个任务...", Thread.currentThread().getName());
            sleep(10);

        });

        sleep(1);

        threadPoolExecutor.execute(() -> {
            log.info("{}:执行第3个任务...", Thread.currentThread().getName());
            //sleep(10);
        });

        sleep(1);

        threadPoolExecutor.execute(() -> {
            log.info("{}:执行第4个任务...", Thread.currentThread().getName());
            //sleep(10);
        });

        sleep(15);

        threadPoolExecutor.execute(() -> {
            log.info("{}:执行第5个任务...", Thread.currentThread().getName());
            sleep(10);
        });

        sleep(1);

        threadPoolExecutor.execute(() -> {
            log.info("{}:执行第6个任务...", Thread.currentThread().getName());
            sleep(10);
        });

        log.info("main结束");
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            log.error("sleep异常", e);
        }
    }
}
