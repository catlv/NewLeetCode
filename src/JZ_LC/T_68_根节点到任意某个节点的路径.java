package JZ_LC;

import java.util.ArrayList;

public class T_68_根节点到任意某个节点的路径 {
    private ArrayList<TreeNode> solve(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        ArrayList<TreeNode> path = new ArrayList<>();
        boolean flag = getPathFromRoot(root, p, path);
        if (flag) {
            return path;
        }
        return null;
    }


    public static boolean getPathFromRoot(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null || node == null) {
            return false;
        }
        path.add(root);

        if (root == node) {
            return true;
        }
        if (root.left != null) {
            if (getPathFromRoot(root.left, node, path)) {
                return true;
            }
        }
        if (root.right != null) {
            if (getPathFromRoot(root.right, node, path)) {
                return true;
            }
        }
        //回溯
        path.remove(path.size() - 1);
        return false;
    }
}
