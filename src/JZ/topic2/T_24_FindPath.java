package JZ.topic2;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class T_24_FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(root, target, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            if (root.left != null) {
                helper(root.left, target, res, list);
            }
            if (root.right != null) {
                helper(root.right, target, res, list);
            }
        }
        list.remove(list.size() - 1); //回溯法，将list中最后一次加入的数给删掉
    }
}
