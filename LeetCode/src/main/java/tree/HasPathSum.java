package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-03-31 15:53
 */
public class HasPathSum {

    public static void main(String[] args) {
        HasPathSum hasPathSum = new HasPathSum();
        Integer[] root1 = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode tree1 = TreeTool.buildTree(root1);
        Integer[] root2 = {-2, null, -3};
        TreeNode tree2 = TreeTool.buildTree(root2);
        System.out.println(hasPathSum.pathSum(tree1, 22));
        //System.out.println(hasPathSum.pathSum(tree2, -5));
    }

    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (pathList.isEmpty()) {
            pathList.add(root.val);
        }
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (Integer i : pathList) {
                sum += i;
            }
            if (sum == targetSum) {
                resList.add(new ArrayList<>(pathList));
            }
        }
        if (root.left != null) {
            pathList.add(root.left.val);
            pathSum(root.left, targetSum);
            pathList.remove(pathList.size() - 1);
        }
        if (root.right != null) {
            pathList.add(root.right.val);
            pathSum(root.right, targetSum);
            pathList.remove(pathList.size() - 1);
        }
        return resList;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            return hasPathSum(root.right, targetSum);
        }
        return false;
    }
}
