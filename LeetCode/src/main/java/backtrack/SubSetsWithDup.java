package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-20 15:23
 */
public class SubSetsWithDup {
    public static void main(String[] args) {
        SubSetsWithDup subSetsWithDup = new SubSetsWithDup();
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {0};
        System.out.println(subSetsWithDup.subsetsWithDup(nums1));
        System.out.println(subSetsWithDup.subsetsWithDup(nums2));
    }

    List<List<Integer>> resList;
    List<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        resList = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        findSubSetsWithDup(nums, 0);
        return resList;
    }

    private void findSubSetsWithDup(int[] nums, int startIndex) {
        resList.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            findSubSetsWithDup(nums, i + 1);
            path.removeLast();
        }
    }
}
