package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-22 14:23
 */
public class PermuteUnique {
    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 1, 2};
        //System.out.println(permuteUnique.permuteUnique(nums1));
        System.out.println(permuteUnique.permuteUnique(nums2));
    }

    List<List<Integer>> resList;
    List<Integer> path;

    public List<List<Integer>> permuteUnique(int[] nums) {
        resList = new ArrayList<>();
        path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        getPermute(nums, used);
        return resList;
    }

    // 去重没有使用used，写不出（难
    // 去重核心是排序后相邻的元素，不需要继续进行处理
    private void getPermute(int[] nums, boolean[] used) {
        if (nums.length == path.size()) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                getPermute(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
