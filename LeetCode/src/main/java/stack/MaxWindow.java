package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author leenadz
 * @since 2025-03-26 13:27
 */
public class MaxWindow {

    public static void main(String[] args) {
        MaxWindow maxWindow = new MaxWindow();

        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] nums2 = {1};
        int k2 = 1;
        int[] nums3 = {7, 2, 4};
        int k3 = 2;
        int[] nums4 = {1, 3, 1, 2, 0, 5};
        int k4 = 3;

        System.out.println(Arrays.toString(maxWindow.maxSlidingWindow(nums1, k1)));
        System.out.println(Arrays.toString(maxWindow.maxSlidingWindow(nums2, k2)));
        System.out.println(Arrays.toString(maxWindow.maxSlidingWindow(nums3, k3)));
        System.out.println(Arrays.toString(maxWindow.maxSlidingWindow(nums4, k4)));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (1 == k) return nums;
        int length = nums.length;
        int[] res = new int[length - k + 1];
        int resPos = 0;
        MyQueue monoQueue = new MyQueue();
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            window.add(nums[i]);
            monoQueue.add(nums[i]);
        }
        res[resPos++] = monoQueue.front();
        for (int i = k; i < length; i++) {
            int num = nums[i];
            monoQueue.remove(window.remove());
            window.add(num);
            monoQueue.add(num);
            res[resPos++] = monoQueue.front();
        }
        return res;
    }

    private class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void remove(int val) {
            if (!deque.isEmpty() && front() == val) {
                deque.remove();
            }
        }

        void add(int val) {
            while (!deque.isEmpty() && deque.peekLast() < val) {
                deque.removeLast();
            }
            deque.add(val);
        }

        int front() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (1 == k) return nums;
        int length = nums.length;
        int[] res = new int[length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int max = 0;
        int resPos = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
            queue.add(nums[i]);
        }
        res[resPos++] = max;

        for (int i = k; i < length; i++) {
            if (!queue.isEmpty() && queue.peek() != max) {
                max = Math.max(max, nums[i]);
            } else {
                // 如果getMax不可能是O(n)
            }
            res[resPos++] = max;
            queue.remove();
            queue.add(nums[i]);
        }
        return res;
    }
}
