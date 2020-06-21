package topic101_200;

public class LC110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(h(root.left) - h(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    private int h(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(h(root.left), h(root.right)) + 1;
    }
}
