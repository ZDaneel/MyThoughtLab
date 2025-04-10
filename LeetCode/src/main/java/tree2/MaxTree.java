package tree2;

import tree.TreeNode;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author leenadz
 * @since 2025-04-06 20:41
 */
public class MaxTree {

    public static void main(String[] args) {
        MaxTree maxTree = new MaxTree();
        int[] arr1 = {3, 2, 1, 6, 0, 5};
        System.out.println(maxTree.constructMaximumBinaryTree(arr1));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return makeTree(nums, 0, nums.length);
    }

    private TreeNode makeTree(int[] nums, int left, int right) {
        int numLen = right - left;
        if (numLen == 0) return null;

        int maxIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(nums[maxIndex]);
        if (numLen == 1) return node;

        node.left = makeTree(nums, left, maxIndex);
        node.right = makeTree(nums, maxIndex + 1, right);

        return node;
    }
}
