package JZ_LC;

import java.util.ArrayList;

public class T_68_二叉树的最近公共祖先2 {
    //非递归法
    ArrayList<TreeNode> a = new ArrayList<>();
    ArrayList<TreeNode> b = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null) {
            return null;
        }
        ArrayList<TreeNode> one = new ArrayList<>();
        ArrayList<TreeNode> two = new ArrayList<>();
        getPathFromRoot(root, p, one);
        getPathFromRoot2(root, q, two);
        TreeNode res = root;
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (a.get(i) == b.get(i)) {
                res = a.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    //根节点到任意某个节点的路径
    public void getPathFromRoot(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null || node == null) {
            return;
        }
        path.add(root);
        if (root == node) {
            a.addAll(path);
            return;
        }
        getPathFromRoot(root.left, node, path);
        getPathFromRoot(root.right, node, path);
        path.remove(path.size() - 1);
    }

    public void getPathFromRoot2(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null || node == null) {
            return;
        }
        path.add(root);
        if (root == node) {
            b.addAll(path);
            return;
        }
        getPathFromRoot2(root.left, node, path);
        getPathFromRoot2(root.right, node, path);
        path.remove(path.size() - 1);
    }
}
