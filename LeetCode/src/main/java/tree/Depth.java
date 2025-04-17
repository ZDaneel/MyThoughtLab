package tree;

/**
 * @author leenadz
 * @since 2025-03-29 16:44
 */
public class Depth {
    public static void main(String[] args) {
        Depth depth = new Depth();
        Integer[] root1 = {3, 9, 20, null, null, 15, 7};
        TreeNode tree1 = TreeTool.buildTree(root1);
        Integer[] root2 = {2, null, 3, null, 4, null, 5, null, 6};
        TreeNode tree2 = TreeTool.buildTree(root2);
        //System.out.println(depth.minDepth(tree1));
        System.out.println(depth.minDepth(tree2));
        System.out.println();
        System.out.println(depth.countNodes(tree1));
        System.out.println(depth.countNodes(tree2));
        System.out.println();
        System.out.println(depth.maxDepth(tree1));
        System.out.println(depth.maxDepth(tree2));
    }

    int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        if (root == null) return 0;
        getDepth(root, 1);
        return maxDepth;
    }

    private void getDepth(TreeNode node, int curDepth) {
        // pre order 中左右
        maxDepth = Math.max(maxDepth, curDepth);
        if (node.left != null) getDepth(node.left, curDepth + 1);
        if (node.right != null) getDepth(node.right, curDepth + 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDep = minDepth(root.left);
        int rightDep = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + rightDep;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftDep;
        }
        return 1 + Math.min(leftDep, rightDep);
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.left == null && root.right != null) {
                return minDepth(root.right) + 1;
            }
            if (root.left != null && root.right == null) {
                return minDepth(root.left) + 1;
            }
            int leftDep = minDepth(root.left);
            int rightDep = minDepth(root.right);
            int depth = Math.min(leftDep, rightDep);
            return depth + 1;
        }
    }

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        int leftCount = 0;
        int rightCount = 0;
        if (root.left != null) leftCount = countNodes(root.left);
        if (root.right != null) rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDep = 0, rightDep = 0;
        while (left != null) {
            left = left.left;
            leftDep++;
        }
        while (right != null) {
            right = right.right;
            rightDep++;
        }
        if (leftDep == rightDep) {
            return (2 << leftDep) - 1;
        }
        int leftTreeNum = countNodes(root.left);
        int rightTreeNum = countNodes(root.right);
        return 1 + leftTreeNum + rightTreeNum;
    }
}
