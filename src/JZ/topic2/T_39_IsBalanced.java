package JZ.topic2;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 方法一：递归函数同时包含高度和是否平衡。
 */
public class T_39_IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getDepth(root.left);
        int rh = getDepth(root.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }
}
