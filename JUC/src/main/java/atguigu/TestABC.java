package atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leenadz
 * @since 2024-09-27 23:25
 */
public class TestABC {
    public static void main(String[] args) {
        // 要求三个线程ABC依次打印 ABC ABC ABC
        AlternateDemo alternateDemo = new AlternateDemo();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                alternateDemo.loopA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                alternateDemo.loopB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                alternateDemo.loopC();
            }
            System.out.println();
        }, "C").start();
    }
}

class AlternateDemo {
    private int number = 1; // 1-A 2-B 3-C
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    public void loopA() {
        lock.lock();
        try {
            while (1 != number) {
                conditionA.await();
            }
            Thread.sleep(200);
            for (int i = 0; i < 2; i++) {
                System.out.print("A");
            }
            number = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void loopB() {
        lock.lock();
        try {
            while (2 != number) {
                conditionB.await();
            }
            Thread.sleep(300);
            for (int i = 0; i < 2; i++) {
                System.out.print("B");
            }
            number = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try {
            while (3 != number) {
                conditionC.await();
            }
            for (int i = 0; i < 2; i++) {
                System.out.print("C");
            }
            number = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
