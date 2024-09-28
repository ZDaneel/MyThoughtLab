package atguigu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author leenadz
 * @since 2024-09-28 21:15
 */
public class TestSchedule {
    public static void main(String[] args) {
        try (ScheduledExecutorService pool = Executors.newScheduledThreadPool(5)) {
            for (int i = 0; i < 10; i++) {
                ScheduledFuture<String> scheduledFuture = pool.schedule(() -> {
                    System.out.println("延迟两秒执行: " + Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                }, 2, TimeUnit.SECONDS);
                System.out.println(scheduledFuture.get());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
