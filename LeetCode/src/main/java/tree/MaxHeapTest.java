package tree;

import java.util.Arrays;
import java.util.Random;

/**
 * @author leenadz
 * @since 2025-03-26 17:36
 */
public class MaxHeapTest {
    // 创建一个基本的最大堆测试
    public static void testBasicOperations() {
        System.out.println("\n=== 基本操作测试 ===");
        MaxHeap maxHeap = new MaxHeap(6);
        System.out.println("新建堆是否为空: " + maxHeap.isEmpty());  // 应该为true

        maxHeap.push(8);
        System.out.println("插入一个元素后是否为空: " + maxHeap.isEmpty());  // 应该为false
        System.out.println("插入一个元素后是否已满: " + maxHeap.isFull());  // 应该为false

        maxHeap.push(7);
        maxHeap.push(0);
        maxHeap.push(1);
        maxHeap.push(6);
        System.out.println("插入五个元素后的堆: " + maxHeap.getAllElements());

        maxHeap.push(9);
        System.out.println("插入第六个元素后是否已满: " + maxHeap.isFull());  // 应该为true
        System.out.println("堆顶元素: " + maxHeap.peek());  // 应该为9
        System.out.println("完整堆内容: " + maxHeap.getAllElements());

        int pop = maxHeap.pop();
        System.out.println("弹出的元素: " + pop);  // 应该为9
        System.out.println("弹出后的堆: " + maxHeap.getAllElements());
    }

    // 测试空堆的操作
    public static void testEmptyHeap() {
        System.out.println("\n=== 空堆测试 ===");
        MaxHeap maxHeap = new MaxHeap(5);

        try {
            System.out.println("尝试从空堆弹出元素");
            maxHeap.pop();
        } catch (Exception e) {
            System.out.println("预期异常: " + e.getMessage());
        }

        try {
            System.out.println("尝试查看空堆的顶部元素");
            maxHeap.peek();
        } catch (Exception e) {
            System.out.println("预期异常: " + e.getMessage());
        }
    }

    // 测试已满堆的操作
    public static void testFullHeap() {
        System.out.println("\n=== 已满堆测试 ===");
        MaxHeap maxHeap = new MaxHeap(3);

        maxHeap.push(3);
        maxHeap.push(1);
        maxHeap.push(2);
        System.out.println("已满堆内容: " + maxHeap.getAllElements());

        try {
            System.out.println("尝试向已满堆添加元素");
            maxHeap.push(4);
        } catch (Exception e) {
            System.out.println("预期异常: " + e.getMessage());
        }
    }

    // 测试相同值元素的处理
    public static void testDuplicateValues() {
        System.out.println("\n=== 重复值测试 ===");
        MaxHeap maxHeap = new MaxHeap(5);

        maxHeap.push(5);
        maxHeap.push(5);
        maxHeap.push(5);
        System.out.println("插入重复值后的堆: " + maxHeap.getAllElements());

        System.out.println("弹出元素: " + maxHeap.pop());
        System.out.println("弹出后的堆: " + maxHeap.getAllElements());
    }

    // 测试负数值的处理
    public static void testNegativeValues() {
        System.out.println("\n=== 负数值测试 ===");
        MaxHeap maxHeap = new MaxHeap(5);

        maxHeap.push(-1);
        maxHeap.push(-5);
        maxHeap.push(-3);
        maxHeap.push(-2);
        maxHeap.push(-4);

        System.out.println("含负数的堆: " + maxHeap.getAllElements());

        System.out.println("弹出元素: " + maxHeap.pop());
        System.out.println("弹出后的堆: " + maxHeap.getAllElements());
    }

    // 测试大量元素的插入和删除
    public static void testManyOperations() {
        System.out.println("\n=== 大量操作测试 ===");
        MaxHeap maxHeap = new MaxHeap(10);

        // 插入10个元素
        for (int i = 0; i < 10; i++) {
            maxHeap.push(i);
        }

        System.out.println("插入10个元素后的堆: " + maxHeap.getAllElements());

        // 弹出5个元素
        System.out.println("弹出的元素:");
        for (int i = 0; i < 5; i++) {
            System.out.print(maxHeap.pop() + " ");
        }
        System.out.println();

        System.out.println("弹出5个元素后的堆: " + maxHeap.getAllElements());

        // 再插入5个元素
        for (int i = 10; i < 15; i++) {
            maxHeap.push(i);
        }

        System.out.println("再插入5个元素后的堆: " + maxHeap.getAllElements());
    }

    // 测试随机数据
    public static void testRandomData() {
        System.out.println("\n=== 随机数据测试 ===");
        MaxHeap maxHeap = new MaxHeap(10);
        Random random = new Random();

        System.out.println("插入的随机数:");
        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(100);
            System.out.print(value + " ");
            maxHeap.push(value);
        }
        System.out.println();

        System.out.println("随机数据堆: " + maxHeap.getAllElements());

        System.out.println("按顺序弹出的元素:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.pop() + " ");
        }
        System.out.println();
    }

    // 测试边界容量
    public static void testEdgeCapacity() {
        System.out.println("\n=== 边界容量测试 ===");

        // 测试容量为1的堆
        MaxHeap singleElementHeap = new MaxHeap(1);
        singleElementHeap.push(42);
        System.out.println("容量为1的堆: " + singleElementHeap.getAllElements());
        System.out.println("是否已满: " + singleElementHeap.isFull());
        System.out.println("弹出元素: " + singleElementHeap.pop());
        System.out.println("弹出后是否为空: " + singleElementHeap.isEmpty());

        try {
            // 测试容量为0的堆（如果允许）
            MaxHeap zeroCapacityHeap = new MaxHeap(0);
            System.out.println("创建容量为0的堆成功");
        } catch (Exception e) {
            System.out.println("创建容量为0的堆失败: " + e.getMessage());
        }
    }

    // 测试堆排序功能
    public static void testHeapSort() {
        System.out.println("\n=== 堆排序测试 ===");
        int[] arr = {5, 2, 9, 1, 5, 6};

        System.out.println("原始数组: " + Arrays.toString(arr));

        // 使用最大堆进行排序
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int value : arr) {
            maxHeap.push(value);
        }

        // 从大到小排序
        int[] sortedDesc = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedDesc[i] = maxHeap.pop();
        }
        System.out.println("降序排序: " + Arrays.toString(sortedDesc));

        // 从小到大排序
        maxHeap = new MaxHeap(arr.length);
        for (int value : arr) {
            maxHeap.push(value);
        }

        int[] sortedAsc = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedAsc[i] = maxHeap.pop();
        }
        System.out.println("升序排序: " + Arrays.toString(sortedAsc));
    }

    public static void main(String[] args) {
        testBasicOperations();
        testEmptyHeap();
        testFullHeap();
        testDuplicateValues();
        testNegativeValues();
        testManyOperations();
        testRandomData();
        testEdgeCapacity();
        testHeapSort();
    }
}
