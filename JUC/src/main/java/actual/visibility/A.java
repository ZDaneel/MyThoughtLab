package actual.visibility;

/**
 * @author leenadz
 * @since 2024-10-24 15:35
 */
public class A implements Runnable {
    public Integer b = 1;

    @Override
    public void run() {
        System.out.println("A is begin!");
        do {
            System.out.println("a");
            System.out.println(b);
        } while (!b.equals(2));

        System.out.println("A is finish!");
    }

    public static void main(String[] args) {
        A a = new A();
        //线程A
        new Thread(a).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.b = 2;
    }
}
