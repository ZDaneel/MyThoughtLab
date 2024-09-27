package array;

import java.util.Arrays;

/**
 * @author leenadz
 * @since 2024-09-26 23:11
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = new RemoveElement().removeElement3(nums, val);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] != val) {
                l++;
                continue;
            }
            if (nums[r] == val) {
                k++;
                r--;
                continue;
            }
            nums[l] = nums[r];
            k++;
            l++;
            r--;
        }
        return nums.length - k;
    }

    // 快慢指针，慢指针包含剩下元素
    public int removeElement2(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] == val) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    nums[fast] = val;
                } else {
                    fast++;
                }
            } else {
                fast++;
                slow++;
            }
        }
        return slow;
    }

    // 快慢指针优化
    public int removeElement3(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
