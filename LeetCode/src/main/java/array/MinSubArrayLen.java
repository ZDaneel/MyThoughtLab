package array;

/**
 * 209
 *
 * @author leenadz
 * @since 2024-09-28 11:56
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int res = new MinSubArrayLen().minSubArrayLen(target, nums);
        System.out.println(res);
    }

    public int minSubArrayLen1(int target, int[] nums) {
        // 超时O(n^2)
        for (int length = 1; length <= nums.length; length++) {
            int index = 0;
            while (index + length <= nums.length) {
                if (sum(nums, index, length) >= target) return length;
                index++;
            }
        }
        return 0;
    }

    private static int sum(int[] nums, int left, int length) {
        int sum = 0;
        for (int i = left; i < left + length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    // 滑动窗口 调整窗口的起始和终止位置 O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                length = Math.min(length, right - left);
                sum -= nums[left++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
