package topic101_200;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 思路：递归法
 * 1.左孩子最小深度设为m，右孩子最小深度设为n
 * 2.左右孩子都为空，说明到达了叶子节点，m = n = 0，返回深度为 m + n + 1 = 1
 * 3.左右孩子某一个为空，说明 m 和 n 当中有一个为 0，返回深度为 m + n + 1 。步骤2和3可以整合到一起。
 * 4.左右孩子都不为空，返回左右孩子里最小的深度+1，返回深度为 Math.min(m,n) + 1
 */
public class LC111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m = minDepth(root.left);
        int n = minDepth(root.right);
        return root.left == null || root.right == null ? m + n + 1 : Math.min(m, n) + 1;
    }
}
