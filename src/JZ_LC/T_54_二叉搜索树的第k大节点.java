package JZ_LC;

import java.util.ArrayList;

/**
 * 首先对二叉搜索树进行中序遍历，并存到数组中
 * 然后返回数组的倒数第k个值即可
 */
public class T_54_二叉搜索树的第k大节点 {
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        //helper方法实现的是中序遍历
        helper(root, list);
        return list.get(list.size() - k);
    }

    private void helper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
