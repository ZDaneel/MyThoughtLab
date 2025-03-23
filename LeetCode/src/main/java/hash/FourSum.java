package hash;

import java.util.*;

/**
 * @author leenadz
 * @since 2025-03-23 19:38
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {2, 2, 2, 2, 2};
        int[] nums3 = {-2, -1, -1, 1, 1, 2, 2};
        int[] nums4 = {1000000000,1000000000,1000000000,1000000000};

//        System.out.println(fourSum.fourSum(nums1, 0));
        //System.out.println(fourSum.fourSum(nums2, 8));
        //System.out.println(fourSum.fourSum(nums3, 0));
        System.out.println(fourSum.fourSum(nums4, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
