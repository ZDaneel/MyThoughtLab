package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类提供了一种使用哈希方法来判断一个树是否是另一个树的子树的方法。
 * 主方法展示了isSubtree方法的使用。
 * 该算法使用质数和模运算来为子树生成唯一的哈希值。
 * 这有助于高效地比较子树。
 *
 * @since 2025-03-29 15:52
 */
public class IsSubTree {
    // 主方法，用于测试isSubtree功能
    public static void main(String[] args) {
        IsSubTree isSubTree = new IsSubTree();
        Integer[] root = {3, 4, 5, 1, 2};
        Integer[] subRoot = {4, 1, 2};
        System.out.println(isSubTree.isSubtree(TreeTool.buildTree(root), TreeTool.buildTree(subRoot)));
    }

    // 最大质数数量和模值的常量
    static final int MAX_N = 1005;
    static final int MOD = 1000000007;

    // 标记非质数的数组
    boolean[] vis = new boolean[MAX_N];
    // 存储质数的数组
    int[] p = new int[MAX_N];
    // 找到的质数总数
    int tot;

    // 用于存储树节点哈希值的哈希映射
    Map<TreeNode, int[]> hS = new HashMap<TreeNode, int[]>();
    Map<TreeNode, int[]> hT = new HashMap<TreeNode, int[]>();

    /**
     * 判断树t是否是树s的子树。
     *
     * @param s 主树的根节点
     * @param t 子树的根节点
     * @return 如果t是s的子树，返回true，否则返回false
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 生成用于哈希的质数
        getPrime();
        // 计算两棵树中所有节点的哈希值
        dfs(s, hS);
        dfs(t, hT);

        // 获取子树根节点的哈希值
        int tHash = hT.get(t)[0];
        // 检查主树中是否有节点的哈希值与子树根节点的哈希值相同
        for (Map.Entry<TreeNode, int[]> entry : hS.entrySet()) {
            if (entry.getValue()[0] == tHash) {
                return true;
            }
        }

        return false;
    }

    /**
     * 使用埃拉托色尼筛法生成最多MAX_N个质数。
     */
    public void getPrime() {
        vis[0] = vis[1] = true; // 0和1不是质数
        tot = 0;
        for (int i = 2; i < MAX_N; ++i) {
            if (!vis[i]) {
                p[++tot] = i; // 存储质数
            }
            for (int j = 1; j <= tot && i * p[j] < MAX_N; ++j) {
                vis[i * p[j]] = true; // 标记质数的倍数为非质数
                if (i % p[j] == 0) {
                    break; // 如果i能被p[j]整除，停止
                }
            }
        }
    }

    /**
     * 深度优先搜索计算每个节点的哈希值。
     *
     * @param o 当前节点
     * @param h 用于存储哈希值的哈希映射
     */
    public void dfs(TreeNode o, Map<TreeNode, int[]> h) {
        h.put(o, new int[]{o.val, 1}); // 初始化节点的哈希值和大小
        if (o.left == null && o.right == null) {
            return; // 如果节点是叶子节点，返回
        }
        if (o.left != null) {
            dfs(o.left, h); // 递归计算左子树的哈希值
            int[] val = h.get(o);
            val[1] += h.get(o.left)[1]; // 更新子树的大小
            val[0] = (int) ((val[0] + (31L * h.get(o.left)[0] * p[h.get(o.left)[1]]) % MOD) % MOD); // 更新哈希值
        }
        if (o.right != null) {
            dfs(o.right, h); // 递归计算右子树的哈希值
            int[] val = h.get(o);
            val[1] += h.get(o.right)[1]; // 更新子树的大小
            val[0] = (int) ((val[0] + (179L * h.get(o.right)[0] * p[h.get(o.right)[1]]) % MOD) % MOD); // 更新哈希值
        }
    }
}