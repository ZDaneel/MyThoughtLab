package tree;

/**
 * @author leenadz
 * @since 2025-03-31 15:10
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        Integer[] root1 = {3, 9, 20, null, null, 15, 7};
        TreeNode tree1 = TreeTool.buildTree(root1);
        Integer[] root2 = {1};
        TreeNode tree2 = TreeTool.buildTree(root2);
        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(tree1));
        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(tree2));
    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        getSum(root, 'm');
        return sum;
    }

    private void getSum(TreeNode node, char position) {
        if (node.left == null && node.right == null) {
            if (position == 'l') sum += node.val;
        }
        if (node.left != null) {
            getSum(node.left, 'l');
        }
        if (node.right != null) {
            getSum(node.right, 'r');
        }
    }
}
