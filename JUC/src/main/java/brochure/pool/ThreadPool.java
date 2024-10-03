package brochure.pool;

import org.junit.Assert;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leenadz
 * @since 2024-10-02 10:34
 */
public class ThreadPool {

    private final ReentrantLock mainLock = new ReentrantLock();

    /**
     * 工作线程
     */
    private final List<Worker> workers = new ArrayList<>();
    /**
     * 任务队列
     */
    private final BlockingQueue<Runnable> workQueue;
    /**
     * 核心线程数
     */
    private final int corePoolSize;
    /**
     * 最大线程数
     */
    private final int maximumPoolSize;
    /**
     * 非核心线程最大空闲时间（否则销毁线程）
     */
    private final long keepAliveTime;

    public ThreadPool(int corePoolSize,
                      int maximumPoolSize,
                      long keepAliveTime,
                      TimeUnit timeUnit,
                      BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = timeUnit.toNanos(keepAliveTime);
    }

    public void execute(Runnable task) {
        Assert.assertNotNull("task is null", task);

        // 创建核心线程处理任务
        if (workers.size() < corePoolSize) {
            this.addWorker(task, true);
            return;
        }

        // 尝试加入任务队列
        boolean enqueued = workQueue.offer(task);
        if (enqueued) {
            return;
        }

        // 创建非核心线程处理任务
        if (!this.addWorker(task, false)) {
            // 非核心线程数达到上限，触发拒绝策略
            throw new RuntimeException("拒绝策略");
        }
    }

    private boolean addWorker(Runnable task, boolean core) {
        // 核心线程数达到上限，不再创建核心线程
        int wc = workers.size();
        if (wc >= (core ? corePoolSize : maximumPoolSize)) {
            return false;
        }

        boolean workerStarted = false;
        try {
            Worker worker = new Worker(task);
            final Thread thread = worker.getThread();
            if (thread != null) {
                mainLock.lock();
                workers.add(worker);
                thread.start();
                workerStarted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mainLock.unlock();
        }

        return workerStarted;
    }

    private void runWorker(Worker worker) {
        Runnable task = worker.getTask();

        try {
            // 循环处理任务
            while (task != null || (task = getTask()) != null) {
                task.run();
                task = null;
            }
        } finally {
            // 从循环退出来，意味着当前线程是非核心线程，而且需要被销毁
            // Java的线程，既可以指代Thread对象，也可以指代JVM线程，一个Thread对象绑定一个JVM线程
            // 因此，线程的销毁分为两个维度：1.把Thread对象从workers移除 2.JVM线程执行完当前任务，会自然销毁
            workers.remove(worker); // 这里前后应该加锁，否则线程不安全。由于是demo，很多处理比较随意
        }
    }


    private Runnable getTask() {
        boolean timedOut = false;

        // 循环获取任务
        for (; ; ) {

            // 是否需要检测超时：当前线程数超过核心线程
            boolean timed = workers.size() > corePoolSize;

            // 需要检测超时 && 已经超时了
            if (timed && timedOut) {
                return null;
            }

            try {
                // 是否需要检测超时
                // 1.需要：poll阻塞获取，等待keepAliveTime，等待结束就返回，不管有没有获取到任务
                // 2.不需要：take持续阻塞，直到获取结果
                Runnable r = timed ?
                        workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
                        workQueue.take();
                if (r != null)
                    return r;
                timedOut = true;
            } catch (InterruptedException retry) {
                timedOut = false;
            }
        }
    }

    @Getter
    @Setter
    private class Worker implements Runnable {
        private Thread thread;
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            runWorker(this);
        }
    }

}
