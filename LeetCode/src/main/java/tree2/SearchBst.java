package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-08 13:18
 */
public class SearchBst {

    public static void main(String[] args) {
        SearchBst searchBst = new SearchBst();
        Integer[] root1 = {4, 2, 7, 1, 3};
        TreeNode tree1 = TreeTool.buildTree(root1);
        System.out.println(searchBst.searchBST2(tree1, 2));
        System.out.println(searchBst.searchBST2(tree1, 5));
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (val > root.val) {
                root = root.right;
            } else if (val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        }
        return root;
    }
}
