package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-17 17:34
 */
public class CombinationSumWithLimit {

    public static void main(String[] args) {
        CombinationSumWithLimit combinationSumWithLimit = new CombinationSumWithLimit();
        int[] arr1 = {10, 1, 2, 7, 6, 1, 5};
        int[] arr2 = {2, 5, 2, 1, 2};
        System.out.println(combinationSumWithLimit.combinationSum2(arr1, 8));
        System.out.println(combinationSumWithLimit.combinationSum2(arr2, 5));
    }

    // candidates 中的每个数字在每个组合中只能使用一次
    // 时间复杂度: O(n * 2^n)
    List<List<Integer>> resList;
    List<Integer> path;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        resList = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0, 0);
        return resList;
    }

    private void findSum(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            if (sum + num > target) break;
            // 核心，跳过重复的元素
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(num);
            findSum(candidates, target, sum + num, i + 1);
            path.removeLast();
        }
    }
}
