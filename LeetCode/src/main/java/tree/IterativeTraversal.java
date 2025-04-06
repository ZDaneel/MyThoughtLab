package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static tree.TreeTool.buildTree;

/**
 * @author leenadz
 * @since 2025-03-27 13:41
 */
public class IterativeTraversal {
    public static void main(String[] args) {
        IterativeTraversal iterativeTraversal = new IterativeTraversal();

        Integer[] root1 = {1, null, 2, 3};
        TreeNode tree1 = buildTree(root1);
        printIterativeTraversal(iterativeTraversal, tree1);
        System.out.println();
        Integer[] root2 = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode tree2 = buildTree(root2);
        printIterativeTraversal(iterativeTraversal, tree2);
        System.out.println();
        Integer[] root3 = {5, 4, 6, 1, 2};
        TreeNode tree3 = buildTree(root3);
        printIterativeTraversal(iterativeTraversal, tree3);
    }

    private static void printIterativeTraversal(IterativeTraversal iterativeTraversal, TreeNode tree) {
        System.out.print("前序: ");
        iterativeTraversal.preorderTraversal(tree).forEach(System.out::print);
        System.out.println();
        System.out.print("中序: ");
        iterativeTraversal.inorderTraversalNull(tree).forEach(System.out::print);
        System.out.println();
        System.out.print("后序: ");
        iterativeTraversal.postorderTraversal(tree).forEach(System.out::print);
        System.out.println();
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode mid = stack.pop();
            if (mid == null) break;
            resList.add(mid.val);
            if (mid.right != null) {
                stack.push(mid.right);
            }
            if (mid.left != null) {
                stack.push(mid.left);
            }
        }
        return resList;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                resList.add(cur.val);
                cur = cur.right;
            }
        }
        return resList;
    }

    public List<Integer> inorderTraversalNull(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                resList.add(node.val);
            }
        }
        return resList;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode mid = stack.pop();
            if (mid == null) break;
            resList.add(mid.val);
            if (mid.left != null) {
                stack.push(mid.left);
            }
            if (mid.right != null) {
                stack.push(mid.right);
            }
        }
        return resList.reversed();
    }
}
