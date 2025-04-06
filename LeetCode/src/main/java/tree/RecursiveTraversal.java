package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static tree.TreeTool.buildTree;

/**
 * @author leenadz
 * @since 2025-03-27 12:48
 */
public class RecursiveTraversal {

    public static void main(String[] args) {
        RecursiveTraversal recursiveTraversal = new RecursiveTraversal();

        Integer[] root1 = {1, null, 2, 3};
        TreeNode tree1 = buildTree(root1);
        printRecursiveTraversal(recursiveTraversal, tree1);
        System.out.println();
        Integer[] root2 = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode tree2 = buildTree(root2);
        printRecursiveTraversal(recursiveTraversal, tree2);
    }

    private static void printRecursiveTraversal(RecursiveTraversal recursiveTraversal, TreeNode tree1) {
        System.out.print("前序: ");
        recursiveTraversal.preorderTraversal(tree1).forEach(System.out::print);
        System.out.println();
        System.out.print("中序: ");
        recursiveTraversal.inorderTraversal(tree1).forEach(System.out::print);
        System.out.println();
        System.out.print("后序: ");
        recursiveTraversal.postorderTraversal(tree1).forEach(System.out::print);
        System.out.println();
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        preorder(root, resList);
        return resList;
    }

    private void preorder(TreeNode root, List<Integer> resList) {
        if (root != null) {
            resList.add(root.val);
            preorder(root.left, resList);
            preorder(root.right, resList);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        inorder(root, resList);
        return resList;
    }

    private void inorder(TreeNode root, List<Integer> resList) {
        if (root != null) {
            inorder(root.left, resList);
            resList.add(root.val);
            inorder(root.right, resList);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        postorder(root, resList);
        return resList;
    }

    private void postorder(TreeNode root, List<Integer> resList) {
        if (root != null) {
            postorder(root.left, resList);
            postorder(root.right, resList);
            resList.add(root.val);
        }
    }
}
