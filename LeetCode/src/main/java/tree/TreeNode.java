package tree;

/**
 * @author leenadz
 * @since 2025-03-27 12:44
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return toStringHelper(this, 0);
    }

    private String toStringHelper(TreeNode node, int level) {
        if (node == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        String indent = "  ".repeat(level); // 使用空格进行缩进

        sb.append(indent).append("TreeNode:\n");
        sb.append(indent).append("  val: ").append(node.val).append("\n");
        sb.append(indent).append("  left: ").append(toStringHelper(node.left, level + 1)).append("\n");
        sb.append(indent).append("  right: ").append(toStringHelper(node.right, level + 1)).append("\n");

        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(root.toString());
    }
}
