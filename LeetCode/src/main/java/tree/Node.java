package tree;

/**
 * @author leenadz
 * @since 2025-03-27 20:39
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node{val=").append(val);

        // 添加 next 信息
        sb.append(", next=");
        if (next == null) {
            sb.append("null");
        } else {
            sb.append("Node{val=").append(next.val).append("}");
        }

        // 添加 left 子节点信息
        sb.append(", left=");
        if (left == null) {
            sb.append("null");
        } else {
            sb.append("Node{val=").append(left.val).append("}");
        }

        // 添加 right 子节点信息
        sb.append(", right=");
        if (right == null) {
            sb.append("null");
        } else {
            sb.append("Node{val=").append(right.val).append("}");
        }

        sb.append("}");
        return sb.toString();
    }
}
