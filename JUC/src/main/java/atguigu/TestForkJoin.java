package atguigu;

import java.io.Serial;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 将一个大任务拆分成多个小任务，最后将多个小任务的结果合并
 * @author leenadz
 * @since 2024-09-28 21:26
 */
public class TestForkJoin {
    public static void main(String[] args) {
        try(ForkJoinPool pool = new ForkJoinPool()) {
            ForkJoinTask<Long> task = new ForkJoinSum(0L, 100000L);
            Long sum = pool.invoke(task);
            System.out.println(sum);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ForkJoinSum extends RecursiveTask<Long> {
    @Serial
    private static final long serialVersionUID = 1L;

    private final long start;
    private final long end;

    private static final long THRESHOLD = 0L; // 临界值

    public ForkJoinSum(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            // 当到达临界值时，开始计算
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // 拆分任务
            long middle = (start + end) / 2;
            ForkJoinSum left = new ForkJoinSum(start, middle);
            left.fork(); // 拆分，并将该子任务压入线程队列
            ForkJoinSum right = new ForkJoinSum(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}