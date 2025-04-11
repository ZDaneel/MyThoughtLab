package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-10 15:56
 */
public class InsertBst {

    public static void main(String[] args) {
        InsertBst insertBst = new InsertBst();
        Integer[] root1 = {4, 2, 7, 1, 3};
        TreeNode tree1 = TreeTool.buildTree(root1);
        System.out.println(insertBst.insertIntoBST(tree1, 5));
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    private void insert(TreeNode node, int val) {
        if (node.val < val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insert(node.right, val);
            }
        } else if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insert(node.left, val);
            }
        }
    }
}
