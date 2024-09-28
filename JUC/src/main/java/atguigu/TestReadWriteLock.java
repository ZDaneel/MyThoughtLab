package atguigu;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author leenadz
 * @since 2024-09-28 19:14
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        new Thread(() -> {
            readWriteLockDemo.set((int) (Math.random() * 101));
        }, "Write").start();
        for (int i = 0; i < 10; i++) {
            new Thread(readWriteLockDemo::get, "Read").start();
        }
    }
}

class ReadWriteLockDemo {
    private int number = 0;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void get() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void set(int number) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
