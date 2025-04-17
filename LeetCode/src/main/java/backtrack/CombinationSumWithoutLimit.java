package backtrack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-17 17:05
 */
public class CombinationSumWithoutLimit {

    public static void main(String[] args) {
        CombinationSumWithoutLimit combinationSumWithoutLimit = new CombinationSumWithoutLimit();
        int[] arr1 = {2, 3, 6, 7};
        int[] arr2 = {2, 3, 5};
        System.out.println(combinationSumWithoutLimit.combinationSum(arr1, 7));
        System.out.println(combinationSumWithoutLimit.combinationSum(arr2, 8));
    }

    // 无限制重复被选取
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        resList = new ArrayList<>();
        path = new ArrayList<>();
        findSum(candidates, target, 0, 0);
        // 此外还可以排序 + 剪枝
        return resList;
    }

    // 使用startIndex保证不会选择之前的元素
    // 例如[2,3,4]，当前节点是3，就只会选择3和4，而不会选择2，确保了不会出现重复
    private void findSum(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) return;

        if (sum == target) {
            resList.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            path.add(num);
            sum += num;
            findSum(candidates, target, sum, i);
            sum -= num;
            path.removeLast();
        }
    }

}
