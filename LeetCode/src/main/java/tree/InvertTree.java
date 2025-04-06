package tree;

/**
 * @author leenadz
 * @since 2025-03-27 21:35
 */
public class InvertTree {

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        Integer[] root1 = {4, 2, 7, 1, 3, 6, 9};
        TreeNode tree1 = TreeTool.buildTree(root1);
        System.out.println(invertTree.invertTree(tree1));
        System.out.println();
        Integer[] root2 = {1};
        TreeNode tree2 = TreeTool.buildTree(root2);
        System.out.println(invertTree.invertTree(tree2));
        System.out.println();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
