package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-10 13:48
 */
public class CommonAncestor {
    public static void main(String[] args) {
        CommonAncestor commonAncestor = new CommonAncestor();
        Integer[] root1 = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode tree1 = TreeTool.buildTree(root1);
        TreeNode p1 = tree1.left;
        TreeNode q1 = tree1.right;
        //System.out.println(commonAncestor.lowestCommonAncestor(tree1, p1, q1));
        //System.out.println("==================================");
        Integer[] root2 = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode tree2 = TreeTool.buildTree(root2);
        TreeNode p2 = tree2.left;
        TreeNode q2 = tree2.left.right.right;
        //System.out.println(commonAncestor.lowestCommonAncestor(tree2, p2, q2));

        Integer[] root3 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode tree3 = TreeTool.buildTree(root3);
        TreeNode p31 = tree3.left;
        TreeNode q31 = tree3.right;
        TreeNode p32 = tree3.left;
        TreeNode q32 = tree3.left.right;
        //System.out.println(commonAncestor.lowestCommonAncestorBst(tree3, p31, q31));
        System.out.println("==================================");
        System.out.println(commonAncestor.lowestCommonAncestorBst(tree3, p32, q32));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.equals(p) || root.equals(q)) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode == null) return leftNode;
        else if (rightNode != null && leftNode == null) return rightNode;
        else if (leftNode != null) return root;
        else return null;
    }

    // 二叉搜索树的最近公共祖先
    // 难
    public TreeNode lowestCommonAncestorBst(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            TreeNode leftNode = lowestCommonAncestorBst(root.left, p, q);
            if (leftNode != null) return leftNode;
        }
        if (root.val < p.val && root.val < q.val) {
            TreeNode rightNode = lowestCommonAncestorBst(root.right, p, q);
            if (rightNode != null) return rightNode;
        }
        return root;
    }
}
