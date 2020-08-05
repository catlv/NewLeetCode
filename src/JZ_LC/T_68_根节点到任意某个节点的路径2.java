package JZ_LC;

import java.util.ArrayList;

public class T_68_根节点到任意某个节点的路径2 {
    ArrayList<TreeNode> p = new ArrayList<>();

    private ArrayList<TreeNode> solve(TreeNode root, TreeNode n) {
        ArrayList<TreeNode> path = new ArrayList<>();
        getPathFromRoot(root, n, path);
        return p;
    }

    //根节点到任意某个节点的路径
    public void getPathFromRoot(TreeNode root, TreeNode n, ArrayList<TreeNode> path) {
        if (root == null || n == null) {
            return;
        }
        path.add(root);
        if (root == n) {
            p.addAll(path);
            return;
        }
        getPathFromRoot(root.left, n, path);
        getPathFromRoot(root.right, n, path);
        path.remove(path.size() - 1);
    }
}
