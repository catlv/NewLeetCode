package topic201_300;

/**
 * 求完全二叉树的节点个数和最大深度
 */
public class LC222 {
    //节点个数
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLevel(root.left);
        int right = getLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    //最大深度
    private int getLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
