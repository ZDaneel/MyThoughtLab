package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-07 23:12
 */
public class MergeTree {
    public static void main(String[] args) {
        MergeTree mergeTree = new MergeTree();
        Integer[] root1 = {1, 3, 2, 5};
        TreeNode tree1 = TreeTool.buildTree(root1);
        Integer[] root2 = {2, 1, 3, null, 4, null, 7};
        TreeNode tree2 = TreeTool.buildTree(root2);
        System.out.println(mergeTree.mergeTrees(tree1, tree2));
        Integer[] root3 = {1, 2, null, 3};
        TreeNode tree3 = TreeTool.buildTree(root3);
        Integer[] root4 = {1, null, 2, null, 3};
        TreeNode tree4 = TreeTool.buildTree(root4);
        System.out.println(mergeTree.mergeTrees(tree3, tree4));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            TreeNode node = new TreeNode(root2.val);
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
            return node;
        }
        if (root2 == null) {
            TreeNode node = new TreeNode(root1.val);
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
            return node;
        }

        TreeNode node = new TreeNode(root1.val + root2.val);

        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);

        return node;
    }
}
