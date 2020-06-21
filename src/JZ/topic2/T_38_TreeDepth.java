package JZ.topic2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class T_38_TreeDepth {
    //递归
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    //非递归，层次遍历
    //count用来统计当前层的节点数
    //nextLevelSize指当前层的下一层的节点数，在当前层通过q.size()得到
    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //LinkedList是Queue的实现。LinkedList实现Deque，Deque继承Queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int deep = 0;
        int count = 0;
        int nextLevelSize = 1;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            count++;
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
            if (count == nextLevelSize) {
                count = 0;
                deep++;
                nextLevelSize = q.size();
            }
        }
        return deep;
    }
}
