package brochure;

/**
 * @author leenadz
 * @since 2024-09-28 22:36
 */
public class TestWorker {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " 主线程开始");
        Worker worker = new Worker();
        worker.begin();
        System.out.println(Thread.currentThread().getName() + " 主线程结束");
    }

    static class Worker implements Runnable {
        public void begin() {
            new Thread(this).start();
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is done");
        }
    }
}