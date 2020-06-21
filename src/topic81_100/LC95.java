package topic81_100;

import java.util.ArrayList;
import java.util.List;

public class LC95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            res.add(null);
            return res;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = helper(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = helper(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    //加入到最终结果中
                    res.add(root);
                }
            }
        }
        return res;
    }
}
