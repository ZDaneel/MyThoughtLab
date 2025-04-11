package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-10 16:20
 */
public class DeleteBst {
    public static void main(String[] args) {
        DeleteBst deleteBst = new DeleteBst();
        Integer[] root1 = {5, 3, 6, 2, 4, null, 7};
        TreeNode tree1 = TreeTool.buildTree(root1);
        System.out.println(deleteBst.deleteNode(tree1, 3));
        System.out.println("===================");
        System.out.println(deleteBst.deleteNode(tree1, 0));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            rightNode = leftNode;
            return root.right;
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);

        return root;
    }
}
