package brochure.pool;

/**
 * @author leenadz
 * @since 2024-10-23 19:52
 */
public interface MyRejectedExecutionHandler {
    void rejectedExecution(Runnable r, ThreadPool executor);
}
