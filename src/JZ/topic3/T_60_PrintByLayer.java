package JZ.topic3;

import java.util.ArrayList;
import java.util.LinkedList;

public class T_60_PrintByLayer {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int start = 0;
        int end = 1;
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            temp.add(node.val);
            start++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (start == end) {
                start = 0;
                end = queue.size();
                res.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        return res;
    }

    //递归法
    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(pRoot, 1, res); //1代表当前二叉树的深度
        return res;
    }

    private void helper(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> res) {
        if (pRoot == null) {
            return;
        }
        if (depth > res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth - 1).add(pRoot.val);

        helper(pRoot.left, depth + 1, res);
        helper(pRoot.right, depth + 1, res);
    }
}
