package tree2;

import tree.TreeNode;
import tree.TreeTool;

import java.util.Arrays;

/**
 * @author leenadz
 * @since 2025-04-06 16:28
 */
public class BuildTreeInPost {

    public static void main(String[] args) {
        BuildTreeInPost buildTreeInPost = new BuildTreeInPost();
        int[] in = {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};
//        TreeNode treeNode = buildTreeInPost.buildTree(in, post);
//        System.out.println(treeNode);
        System.out.println();
        int[] in1 = {1, 2, 3, 4};
        int[] post1 = {3, 4, 2, 1};
        System.out.println(buildTreeInPost.buildTree(in1, post1));
        System.out.println();
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        int nodeVal = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(nodeVal);
        if (postorder.length == 1) return node;

        int inIndex;
        for (inIndex = 0; inIndex < inorder.length; inIndex++) {
            if (inorder[inIndex] == nodeVal) break;
        }

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, inIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, inIndex + 1, inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, inIndex);
        int[] postorderRight = Arrays.copyOfRange(postorder, inIndex, inorder.length - 1);

        node.left = buildTree2(inorderLeft, postorderLeft);
        node.right = buildTree2(inorderRight, postorderRight);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int inorderLeft, int inorderRight, int[] postorder, int postorderLeft, int postorderRight) {
        int inorderLen = inorderRight - inorderLeft;
        int postorderLen = postorderRight - postorderLeft;
        if (postorderLen == 0) return null;
        int nodeVal = postorder[postorderRight - 1];
        TreeNode node = new TreeNode(nodeVal);
        if (postorderLen == 1) return node;

        int inIndex;
        for (inIndex = inorderLeft; inIndex < inorderLen + inorderLeft; inIndex++) {
            if (inorder[inIndex] == nodeVal) break;
        }

        int newInLeftLen = inIndex - inorderLeft;
        node.left = traversal(inorder, inorderLeft, inIndex
                , postorder, postorderLeft, postorderLeft + newInLeftLen);
        node.right = traversal(inorder, inIndex + 1, inorderRight
                , postorder, postorderLeft + newInLeftLen, postorderRight - 1);

        return node;
    }
}
