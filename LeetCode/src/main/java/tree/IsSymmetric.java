package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-03-28 15:26
 */
public class IsSymmetric {
    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        Integer[] arr1 = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root1 = TreeTool.buildTree(arr1);
        System.out.println(isSymmetric.isSymmetric(root1));
        Integer[] arr2 = {1, 2, 2, null, 3, null, 3};
        TreeNode root2 = TreeTool.buildTree(arr2);
        System.out.println(isSymmetric.isSymmetric(root2));

        System.out.println(isSymmetric.isSameTree(root1, root2));
        System.out.println(isSymmetric.isSameTree(root2, root2));

        System.out.println();
        Integer[] root = {3, 4, 5, 1, 2};
        Integer[] subRoot = {4, 1, 2};
        System.out.println(isSymmetric.isSubtree(TreeTool.buildTree(root), TreeTool.buildTree(subRoot)));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (isSameTree(node, subRoot)) return true;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) return false;
        else if (p != null && q == null) return false;
        else if (p == null) return true;
        else if (p.val != q.val) return false;

        boolean leftRes = isSameTree(p.left, q.left);
        boolean rightRes = isSameTree(p.right, q.right);

        return leftRes && rightRes;
    }

    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root.left == null && root.right != null) return false;
        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size % 2 != 0) return false;
            for (int i = 0; i < size; i = i + 2) {
                TreeNode left = queue.remove();
                TreeNode right = queue.remove();
                if (left == null && right != null) return false;
                if (left != null && right == null) return false;
                if (left != null) {
                    if (left.val != right.val) return false;
                    queue.add(left.left);
                    queue.add(right.right);
                    queue.add(left.right);
                    queue.add(right.left);
                }
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root.left == null && root.right != null) return false;
        if (root.left != null) queue.push(root.left);
        if (root.right != null) queue.push(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size % 2 != 0) return false;
            for (int i = 0; i < size; i = i + 2) {
                TreeNode left = queue.pop();
                TreeNode right = queue.pop();
                if (left == null && right != null) return false;
                if (left != null && right == null) return false;
                if (left != null) {
                    if (left.val != right.val) return false;
                    queue.push(left.left);
                    queue.push(right.right);
                    queue.push(left.right);
                    queue.push(right.left);
                }
            }
        }
        return true;
    }

    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null) return true;
        else if (left.val != right.val) return false;

        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}
