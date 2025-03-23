package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leenadz
 * @since 2025-03-23 13:42
 */
public class FourSumCount {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(new FourSumCount().
                fourSumCount(nums1, nums2, nums3, nums4));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> twoSumCountMap = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int twoSum = num1 + num2;
                twoSumCountMap.merge(twoSum, 1, Integer::sum);
            }
        }
        int count = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int target = -(num3 + num4);
                if (twoSumCountMap.get(target) != null) {
                    count += twoSumCountMap.get(target);
                }
            }
        }
        return count;
    }
}
