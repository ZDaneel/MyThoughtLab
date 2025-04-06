package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leenadz
 * @since 2025-03-27 13:42
 */
public class TreeTool {
    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            // 处理右子节点
            if (i < array.length) {
                if (array[i] != null) {
                    current.right = new TreeNode(array[i]);
                    queue.offer(current.right);
                }
                i++;
            }
        }

        return root;
    }

    public static Node buildNextTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        Node root = new Node(array[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            Node current = queue.poll();

            // 处理左子节点
            if (array[i] != null) {
                current.left = new Node(array[i]);
                queue.offer(current.left);
            }
            i++;

            // 处理右子节点
            if (i < array.length) {
                if (array[i] != null) {
                    current.right = new Node(array[i]);
                    queue.offer(current.right);
                }
                i++;
            }
        }

        return root;
    }
}
