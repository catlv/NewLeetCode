package JZ.topic3;

import java.util.ArrayList;
import java.util.LinkedList;

public class T_60_LevelOrder {
    public ArrayList<Integer> leverOrder(TreeNode pRoot) {
        ArrayList<Integer> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }
}
