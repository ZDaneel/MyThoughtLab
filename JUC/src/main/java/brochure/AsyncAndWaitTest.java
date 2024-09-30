package brochure;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author leenadz
 * @since 2024-09-28 22:47
 */
public class AsyncAndWaitTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Callable往FutureTask
//        FutureTask<String> futureTask = new FutureTask<>(() -> {
//            System.out.println(Thread.currentThread().getName() + "========>正在执行");
//            try {
//                Thread.sleep(3 * 1000L);
//            } catch (InterruptedException ignored) {
//            }
//            return "success";
//        });

        // Runnable往FutureTask
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "========>正在执行");
            try {
                Thread.sleep(3 * 1000L);
            } catch (InterruptedException ignored) {
            }
        }, "success"); // Adapter处理Runnable+result为Callable


        // 把FutureTask塞到Thread
        new Thread(futureTask).start();
        System.out.println(Thread.currentThread().getName() + "========>启动任务");


        // 可以获取异步结果（会阻塞3秒）
        String result = futureTask.get();
        System.out.println("任务执行结束，result====>" + result);
    }

}
