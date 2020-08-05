package topic101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 之字型打印二叉树
 * tips：ArrayList.add(index,e) 表示将 index 下标位置的数和它后面所有的数一块后移一位
 * 然后在空出的 index 位置上加入 e。
 */
public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int level = 0;
        dfs(root, result, level);
        return result;
    }

    public void dfs(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() <= level) {
            List<Integer> newLevel = new ArrayList<Integer>();
            list.add(newLevel);
        }
        List<Integer> curList = list.get(level);
        if ((level & 1) == 0) {
            curList.add(node.val);
        } else {
            curList.add(0, node.val);
        }
        dfs(node.left, list, level + 1);
        dfs(node.right, list, level + 1);
    }
}
