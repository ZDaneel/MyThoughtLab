package advanced.myaop;

/**
 * @author leenadz
 * @since 2024-10-12 10:43
 */
public class TestImpl implements Test{
    @Loggable
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }
}
