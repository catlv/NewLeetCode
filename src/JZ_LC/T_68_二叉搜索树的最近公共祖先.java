package JZ_LC;

public class T_68_二叉搜索树的最近公共祖先 {
    //非递归法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    //递归法
    public TreeNode rec(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return rec(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return rec(root.right, p, q);
        }
        return root;
    }
}
