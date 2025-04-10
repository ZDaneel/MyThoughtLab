package tree2;

import tree.TreeNode;
import tree.TreeTool;

import java.util.*;

/**
 * @author leenadz
 * @since 2025-04-08 17:21
 */
public class FindMode {

    public static void main(String[] args) {
        FindMode findMode = new FindMode();
        Integer[] root1 = {1, 0, 1, 0, 0, 1, 1, 0};
        TreeNode tree1 = TreeTool.buildTree(root1);
        System.out.println(Arrays.toString(findMode.findMode(tree1)));
    }

    int count;
    int maxCount;
    TreeNode pre;
    List<Integer> resList;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        count = 0;
        maxCount = 0;
        resList = new ArrayList<>();
        searchMax(root);
        int[] resArr = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    // 自己没写出来
    private void searchMax(TreeNode node) {
        if (node != null) {
            searchMax(node.left);
            if (pre == null) {
                count = 1;
            } else if (pre.val == node.val) {
                count++;
            } else {
                count = 1;
            }

            if (count == maxCount) {
                resList.add(node.val);
            }

            if (count > maxCount) {
                maxCount = count;
                resList.clear();
                resList.add(node.val);
            }

            pre = node;
            searchMax(node.right);
        }
    }

    Map<Integer, Integer> countMap;

    public int[] findMode1(TreeNode root) {
        countMap = new HashMap<>();
        traversal(root);
        List<Map.Entry<Integer, Integer>> countList = new ArrayList<>(countMap.entrySet());
        countList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int maxFreq = countList.get(0).getValue();
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : countList) {
            if (integerIntegerEntry.getValue() != maxFreq) break;
            resList.add(integerIntegerEntry.getKey());
        }
        int[] resArr = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    private void traversal(TreeNode node) {
        if (node != null) {
            traversal(node.left);
            countMap.merge(node.val, 1, Integer::sum);
            traversal(node.right);
        }
    }
}
