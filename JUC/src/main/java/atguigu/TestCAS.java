package atguigu;

/**
 * @author leenadz
 * @since 2024-09-26 19:43
 */
public class TestCAS {
    public static void main(String[] args) {
        final MyCAS myCAS = new MyCAS();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectedValue = myCAS.get();
                boolean b = myCAS.compareAndSet(expectedValue, (int) (Math.random() * 101));
                System.out.println(b);
            }).start();
        }
    }
}

class MyCAS {
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}
