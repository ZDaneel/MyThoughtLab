package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leenadz
 * @since 2025-03-22 20:20
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        System.out.println(Arrays.toString(twoSum.twoSum(nums1, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(nums1, 22)));
        System.out.println(Arrays.toString(twoSum.twoSum(nums2, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum(nums3, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = target - num;
            if (map.get(temp) != null) {
                res[0] = i;
                res[1] = map.get(temp);
                return res;
            }
            map.put(num, i);
        }
        return null;
    }
}
