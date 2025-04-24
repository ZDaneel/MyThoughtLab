package tree2;

import tree.TreeNode;
import tree.TreeTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-04-08 13:37
 */
public class IsValidBst {

    public static void main(String[] args) {
        IsValidBst isValidBst = new IsValidBst();
        Integer[] root1 = {5, 1, 4, null, null, 3, 6};
        TreeNode tree1 = TreeTool.buildTree(root1);
        System.out.println(isValidBst.isValidBST(tree1));
        Integer[] root2 = {1, 1};
        TreeNode tree2 = TreeTool.buildTree(root2);
        System.out.println(isValidBst.isValidBST(tree2));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lowerBound, long upperBound) {
        if (node == null) {
            return true;
        }

        // 检查当前节点的值是否在有效范围内
        if (node.val <= lowerBound || node.val >= upperBound) {
            return false;
        }

        // 递归检查
        return isValidBST(node.left, lowerBound, node.val) &&
                isValidBST(node.right, node.val, upperBound);
    }

    long max = Long.MIN_VALUE;

    public boolean isValidBST3(TreeNode root) {
        max = Long.MIN_VALUE;
        return judge(root);
    }

    private boolean judge(TreeNode root) {
        boolean left = true;
        boolean right = true;
        if (root != null) {
            left = judge(root.left);
            if (root.val > max) {
                max = root.val;
            } else {
                return false;
            }
            right = judge(root.right);
        }
        return left && right;
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> numList = new ArrayList<>();
        getList(root, numList);
        if (numList.isEmpty()) return false;
        int pre = numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            Integer cur = numList.get(i);
            if (cur <= pre) return false;
            pre = cur;
        }
        return true;
    }

    private void getList(TreeNode root, List<Integer> numList) {
        if (root != null) {
            getList(root.left, numList);
            numList.add(root.val);
            getList(root.right, numList);
        }
    }
}
