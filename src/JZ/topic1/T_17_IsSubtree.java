package JZ.topic1;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（约定空树不是任意一个树的子结构）
 */
public class T_17_IsSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2) || helper(root1, root2);
    }

    //helper用来判断root2是否为root1此处的子结构
    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}