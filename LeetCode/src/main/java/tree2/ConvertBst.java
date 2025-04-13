package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-13 12:05
 */
public class ConvertBst {

    public static void main(String[] args) {
        ConvertBst convertBst = new ConvertBst();
        Integer[] root1 = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        System.out.println(convertBst.convertBST(TreeTool.buildTree(root1)));
        System.out.println("======================");
        Integer[] root2 = {0, null, 1};
        System.out.println(convertBst.convertBST(TreeTool.buildTree(root2)));
        System.out.println("======================");
        Integer[] root3 = {1, 0, 2};
        System.out.println(convertBst.convertBST(TreeTool.buildTree(root3)));
        System.out.println("======================");
        Integer[] root4 = {3, 2, 4, 1};
        System.out.println(convertBst.convertBST(TreeTool.buildTree(root4)));
        System.out.println("======================");

    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convert(root);
        return root;
    }

    int sum = 0;

    private void convert(TreeNode node) {
        if (node != null) {
            convert(node.right);
            node.val += sum;
            sum = node.val;
            convert(node.left);
        }
    }
}
