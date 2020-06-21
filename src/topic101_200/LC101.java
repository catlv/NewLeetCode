package topic101_200;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 思路：同时满足以下两个条件时，两树才为镜像：
 * 1.两树的根节点值相同
 * 2.一个树的右子树与另一个树的左子树镜像对称
 */
public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    //剑指offer的题：将一棵树变换为它的镜像。
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
