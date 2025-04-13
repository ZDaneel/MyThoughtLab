package tree2;

import tree.TreeNode;
import tree.TreeTool;

/**
 * @author leenadz
 * @since 2025-04-13 11:33
 */
public class Arr2Bst {

    public static void main(String[] args) {
        Arr2Bst arr2Bst = new Arr2Bst();
        int[] arr1 = {-10, -3, 0, 5, 9};
        System.out.println(arr2Bst.sortedArrayToBST(arr1));
        System.out.println("============");
        int[] arr2 = {1, 3};
        System.out.println(arr2Bst.sortedArrayToBST(arr2));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + ((right - left) / 2);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums, left, mid - 1);
        node.right = makeTree(nums, mid + 1, right);
        return node;
    }
}
