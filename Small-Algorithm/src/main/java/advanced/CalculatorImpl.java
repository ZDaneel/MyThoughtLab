package advanced;

/**
 * @author leenadz
 * @since 2024-10-02 19:25
 */

/**
 * 目标类，实现Calculator接口（如果一开始就面向接口编程，其实是不存在这一步的，CalculatorImpl原本就实现Calculator接口）
 */
public class CalculatorImpl implements Calculator {
    private int test = 0;

    public CalculatorImpl() {
    }

    public CalculatorImpl(int test) {
        this.test = test;
    }

    // 加
    public int add(int a, int b) {
        System.out.println("add方法执行了" + test);
        return a + b;
    }

    // 减
    public int subtract(int a, int b) {
        return a - b;
    }

    // 乘法、除法...
}
