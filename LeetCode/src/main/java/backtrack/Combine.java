package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-06 21:04
 */
public class Combine {

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 4));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resLists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        return makeCombine(n, k, 0, resLists, path);
    }

    private List<List<Integer>> makeCombine(int n, int k, int index, List<List<Integer>> resLists, List<Integer> path) {
        if (path.size() == k) {
            resLists.add(new ArrayList<>(path));
        } else {
            // [1 ... n]
            for (int i = index; i < n - (k - path.size()) + 1; i++) {
//                // 剪枝
//                if (path.size() + (n - i + 1) < k) {
//                    continue;
//                }
                int num = i + 1;
                path.add(num);
                makeCombine(n, k, num, resLists, path);
                path.remove(path.size() - 1);
            }
        }
        return resLists;
    }

    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> resLists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        return makeCombine1(n, k, 0, resLists, path);
    }

    private List<List<Integer>> makeCombine1(int n, int k, int index, List<List<Integer>> resLists, List<Integer> path) {
        if (path.size() == k) {
            resLists.add(new ArrayList<>(path));
        } else {
            // [1 ... n]
            for (int i = index; i < n; i++) {
                int num = i + 1;
                path.add(num);
                makeCombine1(n, k, num, resLists, path);
                path.remove(path.size() - 1);
            }
        }
        return resLists;
    }
}
