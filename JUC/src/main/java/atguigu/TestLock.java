package atguigu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leenadz
 * @since 2024-09-27 14:30
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "Window 1").start();
        new Thread(ticket, "Window 2").start();
        new Thread(ticket, "Window 3").start();

    }
}

class Ticket implements Runnable {

    private int tick = 100;
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tick > 0) {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName() + " has " + --tick + " tickets left.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
