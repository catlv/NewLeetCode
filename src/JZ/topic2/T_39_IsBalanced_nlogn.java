package JZ.topic2;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 方法二：左右两子树高度差的绝对值不超过1，并且左右两子树都是平衡二叉树
 * 主函数时间复杂度 O(n)，depth的时间复杂度O(logn).整体复杂度为O(nlogn)
 */
public class T_39_IsBalanced_nlogn {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
