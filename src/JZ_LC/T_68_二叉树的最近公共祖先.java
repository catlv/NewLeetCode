package JZ_LC;

import java.util.ArrayList;

public class T_68_二叉树的最近公共祖先 {
    //非递归法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null) {
            return null;
        }
        ArrayList<TreeNode> one = new ArrayList<>();
        ArrayList<TreeNode> two = new ArrayList<>();
        boolean flag1 = getPathFromRoot(root, p, one);
        boolean flag2 = getPathFromRoot(root, q, two);
        TreeNode res = new TreeNode(0);
        if (flag1 && flag2) {
            int len = Math.min(one.size(), two.size());
            for (int i = 0; i < len; i++) {
                if (one.get(i) == two.get(i)) {
                    res = one.get(i);
                } else {
                    break;
                }
            }
        }
        return res;
    }

    //根节点到任意某个节点的路径
    public static boolean getPathFromRoot(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null || node == null) {
            return false;
        }
        path.add(root);

        if (root == node) {
            return true;
        }
        if (getPathFromRoot(root.left, node, path)) {
            return true;
        }
        if (getPathFromRoot(root.right, node, path)) {
            return true;
        }
        //回溯
        path.remove(path.size() - 1);
        return false;
    }

    //递归法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //此处的if判断，表示找到p或q后便return root 到left或right中，来通知root的父节点。
        //而且如果另一个节点在root的子树中也就不需要判断了,因为它们的最近公共祖先肯定就是此时的root了。
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        //如果left为null，表示在左子树中没有找到p和q，那么p和q就在右子树中
        //如果left和right都不为null，表示在左右子树中都能找到p或q，也就是一边一个，那么结果就为root了。
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
