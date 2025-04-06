package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-03-31 14:26
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        Integer[] root1 = {1, 2, 3, null, 5};
        TreeNode tree1 = TreeTool.buildTree(root1);
        Integer[] root2 = {2, null, 3, null, 4, null, 5, null, 6};
        TreeNode tree2 = TreeTool.buildTree(root2);
        System.out.println(binaryTreePaths.binaryTreePaths(tree1));
        System.out.println(binaryTreePaths.binaryTreePaths(tree2));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<String> resList = new ArrayList<>();
        preorder(root, path, resList);
        return resList;
    }

    private void preorder(TreeNode node, List<Integer> path, List<String> resList) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            // [1, 2, 3] 转 1->2->3
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.getLast());
            resList.add(sb.toString());
        }

        if (node.left != null) {
            preorder(node.left, path, resList);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            preorder(node.right, path, resList);
            path.remove(path.size() - 1);
        }
    }
}
