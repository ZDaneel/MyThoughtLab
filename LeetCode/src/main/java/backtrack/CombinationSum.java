package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-07 21:23
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum3(3, 7));
        System.out.println(combinationSum.combinationSum3(3, 9));
    }

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        build(k, n, 1, 0);
        return ans;
    }

    private void build(int k, int n, int startIndex, int sum) {
        if (sum > n) return;

        if (path.size() > k) return;

        if (sum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            build(k, n, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum32(int k, int n) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        return findSum32(k, n, 0, path, resList);
    }

    public List<List<Integer>> findSum32(int k, int n, int index, List<Integer> path, List<List<Integer>> resList) {
        if (path.size() == k) {
            if (0 == n) {
                resList.add(new ArrayList<>(path));
            }
        } else {
            for (int i = index; i <= 9 - (k - path.size()) + 1; i++) {
                if (n < 0) {
                    continue;
                }
                int num = i + 1;
                path.add(num);
                n -= num;
                findSum32(k, n, num, path, resList);
                path.removeLast();
                n += num;
            }
        }
        return resList;
    }

    public List<List<Integer>> combinationSum31(int k, int n) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        return findSum31(k, n, 0, path, resList);
    }

    public List<List<Integer>> findSum31(int k, int n, int index, List<Integer> path, List<List<Integer>> resList) {
        if (path.size() == k) {
            int sum = 0;
            for (Integer i : path) {
                sum += i;
            }
            if (sum == n) {
                resList.add(new ArrayList<>(path));
            }
        } else {
            for (int i = index; i < 9; i++) {
                int num = i + 1;
                path.add(num);
                findSum31(k, n, num, path, resList);
                path.removeLast();
            }
        }
        return resList;
    }

}
