package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-20 15:07
 */
public class SubSets {
    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {0};
        System.out.println(subSets.subsets(nums1));
        System.out.println(subSets.subsets(nums2));
    }

    List<List<Integer>> resList;
    List<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        resList = new ArrayList<>();
        path = new ArrayList<>();
        findSubSets(nums, 0);
        return resList;
    }

    private void findSubSets(int[] nums, int startIndex) {
        resList.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            findSubSets(nums, i + 1);
            path.removeLast();
        }
    }
}
