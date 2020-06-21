package topic81_100;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class LC98 {
    //先序递归
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower) {
            return false;
        }
        if (root.val >= upper) {
            return false;
        }
        if (!dfs(root.left, lower, root.val)) {
            return false;
        }
        if (!dfs(root.right, root.val, upper)) {
            return false;
        }
        return true;
    }

    //中序递归
    long lastVal = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val <= lastVal) {
            return false;
        } else {
            lastVal = root.val;
        }
        if (!isValidBST2(root.right)) {
            return false;
        }
        return true;
    }

    //使用栈来实现，时间复杂度较差。
    public Boolean isValidBST_Stack(TreeNode root) {
        int lastVal = Integer.MIN_VALUE;
        boolean res = true;
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (root.val > lastVal) {
                        lastVal = root.val;
                    } else {
                        res = false;
                    }
                    root = root.right;
                }
            }
        }
        return res;
    }
}
