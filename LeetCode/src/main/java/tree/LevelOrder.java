package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * @author leenadz
 * @since 2025-03-27 19:00
 */
public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        Integer[] root1 = {3, 9, 20, null, null, 15, 7};
        TreeNode tree1 = TreeTool.buildTree(root1);
        System.out.println(levelOrder.levelOrder(tree1));
        System.out.println();
        System.out.println(levelOrder.levelOrderBottom(tree1));
        System.out.println();
        System.out.println(levelOrder.rightSideView(tree1));
        System.out.println();

        Integer[] root2 = {1, 2, 3, 4, 5, 6, 7};
        Node node = TreeTool.buildNextTree(root2);
        Node connect = levelOrder.connect(node);
        System.out.println(connect);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                levelList.add(node.val);
            }
            resList.add(levelList);
        }
        return resList;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return levelOrder(root).reversed();
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (i == size - 1) {
                    resList.add(node.val);
                }
            }
        }
        return resList;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resList.add((sum / size));
        }
        return resList;
    }

    public List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        Deque<NTreeNode> nodeDeque = new LinkedList<>();
        if (root != null) nodeDeque.add(root);
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NTreeNode node = nodeDeque.remove();
                levelList.add(node.val);
                List<NTreeNode> childrenList = node.children;
                for (NTreeNode childNode : childrenList) {
                    if (childNode != null) nodeDeque.add(childNode);
                }
            }
            resList.add(levelList);
        }
        return resList;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                max = Math.max(node.val, max);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resList.add(max);
        }
        return resList;
    }

    public Node connect(Node root) {
        Deque<Node> nodeQueue = new LinkedList<>();
        if (root != null) nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                Node node = nodeQueue.remove();
                if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = nodeQueue.peek();
                }
                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public int maxDepth1(TreeNode root) {
        int depth = 0;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.remove();
                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth2(root.left);
            int rightDepth = maxDepth2(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public int minDepth(TreeNode root) {
        int depth = 1;
        int minDepth = Integer.MAX_VALUE;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.remove();
                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);
                if (node.left == null && node.right == null) {
                    minDepth = Math.min(minDepth, depth);
                }
            }
            depth++;
        }
        return minDepth;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = minDepth2(root.left);
            int rightDepth = minDepth2(root.right);
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
