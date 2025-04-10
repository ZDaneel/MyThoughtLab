package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-08 16:21
 */
public class GetMinDiff {

    public static void main(String[] args) {
        GetMinDiff getMinDiff = new GetMinDiff();
        Integer[] root1 = {4, 2, 6, 1, 3};
        TreeNode tree1 = TreeTool.buildTree(root1);
        System.out.println(getMinDiff.getMinimumDifference(tree1));
        Integer[] root2 = {236, 104, 701, null, 227, null, 911};
        TreeNode tree2 = TreeTool.buildTree(root2);
        System.out.println(getMinDiff.getMinimumDifference(tree2));
    }

    int min = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        min = Integer.MAX_VALUE;
        traversal(root);
        return min;
    }

    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }

    public int getMinimumDifferenceErr(TreeNode root) {
        int diff = Integer.MAX_VALUE;
        if (root != null) {
            getMinimumDifferenceErr(root.left);
            if (root.left != null && root.right == null) {
                diff = Math.abs(root.val - root.left.val);
            }
            if (root.left == null && root.right != null) {
                diff = Math.abs(root.val - root.right.val);
            }
            if (root.left != null && root.right != null) {
                diff = Math.min(
                        Math.abs(root.val - root.left.val),
                        Math.abs(root.val - root.right.val)
                );
            }
            if (min > diff) min = diff;
            getMinimumDifferenceErr(root.right);
        }
        return min;
    }
}
