package advanced.myaop;

/**
 * @author leenadz
 * @since 2024-10-12 10:43
 */
public class Main {
    public static void main(String[] args) {
        Test test = new TestImpl();
        Test proxy = ProxyFactory.createProxy(test);

        proxy.add(1, 2);
        proxy.subtract(5, 3);
    }
}
