package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author leenadz
 * @since 2025-03-31 15:29
 */
public class FindBottomLeft {
    public static void main(String[] args) {
        FindBottomLeft findBottomLeft = new FindBottomLeft();
        Integer[] root1 = {2, 1, 3};
        TreeNode tree1 = TreeTool.buildTree(root1);
        Integer[] root2 = {1, 2, 3, 4, null, 5, 6, null, null, 7};
        TreeNode tree2 = TreeTool.buildTree(root2);
        System.out.println(findBottomLeft.findBottomLeftValue(tree1));
        System.out.println(findBottomLeft.findBottomLeftValue(tree2));
    }

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null && i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
