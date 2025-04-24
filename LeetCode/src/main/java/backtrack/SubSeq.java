package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leenadz
 * @since 2025-04-21 12:48
 */
public class SubSeq {
    public static void main(String[] args) {
        SubSeq subSeq = new SubSeq();
        int[] nums1 = {4, 6, 7, 7};
        int[] nums2 = {4, 4, 3, 2, 1};
        System.out.println(subSeq.findSubsequences(nums1));
        System.out.println(subSeq.findSubsequences(nums2));
        int[] nums3 = {1, 2, 1, 1};
        System.out.println(subSeq.findSubsequences(nums3));
    }

    List<List<Integer>> resList;
    List<Integer> path;

    public List<List<Integer>> findSubsequences(int[] nums) {
        resList = new ArrayList<>();
        path = new ArrayList<>();
        getSeq(nums, 0);
        return resList;
    }

    private void getSeq(int[] nums, int startIndex) {
        if (path.size() > 1) {
            resList.add(new ArrayList<>(path));
        }
        Set<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && path.getLast() > nums[i] || hs.contains(nums[i]))
                continue;
            hs.add(nums[i]);
            path.add(nums[i]);
            getSeq(nums, i + 1);
            path.removeLast();
        }
    }
    // 没写完整 --> 错误在于去重逻辑，nums[i] == nums[i - 1]只能处理已排序的数组
    private void getSeq2(int[] nums, int startIndex) {
        if (path.size() > 1) {
            resList.add(new ArrayList<>(path));
        }
        int max = Integer.MIN_VALUE;
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] < max) {
                continue;
            }
            max = nums[i];
            path.add(nums[i]);
            getSeq2(nums, i + 1);
            path.removeLast();
        }
    }
}
