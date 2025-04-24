package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-22 14:01
 */
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0, 1};
        int[] nums3 = {0};
        System.out.println(permute.permute(nums1));
        System.out.println(permute.permute(nums2));
        System.out.println(permute.permute(nums3));
    }


    List<List<Integer>> resList;
    List<Integer> path;

    public List<List<Integer>> permute(int[] nums) {
        resList = new ArrayList<>();
        path = new ArrayList<>();
        //getPermute(nums);
        boolean[] used = new boolean[nums.length];
        getPermute(nums, used);
        return resList;
    }

    private void getPermute(int[] nums, boolean[] used) {
        if (nums.length == path.size()) {
            resList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                getPermute(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    private void getPermute(int[] nums) {
        if (nums.length == path.size()) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) continue; // 改为boolean[] used更好，能够和有重复的全排列对应
            path.add(num);
            getPermute(nums);
            path.removeLast();
        }
    }
}
