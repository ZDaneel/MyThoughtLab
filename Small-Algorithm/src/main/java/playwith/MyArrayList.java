package playwith;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leenadz
 * @since 2024-09-24 15:00
 */
public class MyArrayList {
    // 简单的整数数组实现
    private int[] array;
    private int size;
    private final ReentrantLock lock = new ReentrantLock();

    public MyArrayList() {
        array = new int[10];
        size = 0;
    }

//    public synchronized void add(int element) {
//        if (size == array.length) {
//            int[] newArray = new int[array.length * 2];
//            System.arraycopy(array, 0, newArray, 0, array.length);
//            array = newArray;
//        }
//        array[size++] = element;
//    }

    public void add(int element) {
        lock.lock(); // 获取锁
        try {
            if (size == array.length) {
                int[] newArray = new int[array.length * 2];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
            array[size++] = element;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("List size: " + list.size());
        System.out.println("List elements: " + list);
    }
}
