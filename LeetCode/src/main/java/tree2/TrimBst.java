package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-13 10:56
 */
public class TrimBst {

    public static void main(String[] args) {
        TrimBst trimBst = new TrimBst();
        Integer[] root1 = {3, 0, 4, null, 2, null, null, 1};
        System.out.println(trimBst.trimBST(TreeTool.buildTree(root1), 1, 3));
        System.out.println("=====================");
        System.out.println(trimBst.trimBST(TreeTool.buildTree(root1), 0, 2));
        System.out.println("=====================");
        Integer[] root2 = {1, 0, 2};
        System.out.println(trimBst.trimBST(TreeTool.buildTree(root2), 1, 2));
        System.out.println("=====================");
        Integer[] root3 = {3, 1, 4, null, 2};
        System.out.println(trimBst.trimBST(TreeTool.buildTree(root3), 3, 4));
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
