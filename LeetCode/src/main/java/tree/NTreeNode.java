package tree;

import java.util.Arrays;
import java.util.List;

/**
 * @author leenadz
 * @since 2025-03-27 20:18
 */
public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {}

    public NTreeNode(int _val) {
        val = _val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
