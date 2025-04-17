package tree;

/**
 * @author leenadz
 * @since 2025-03-31 12:48
 */
public class IsBalanced {

    public static void main(String[] args) {
        IsBalanced isBalanced = new IsBalanced();
        Integer[] root1 = {3, 9, 20, null, null, 15, 7};
        TreeNode tree1 = TreeTool.buildTree(root1);
        Integer[] root2 = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode tree2 = TreeTool.buildTree(root2);

        System.out.println(isBalanced.isBalanced(tree1));
        System.out.println(isBalanced.isBalanced(tree2));
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        boolean leftRes = isBalanced(root.left);
        boolean rightRes = isBalanced(root.right);
        return leftRes && rightRes;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
