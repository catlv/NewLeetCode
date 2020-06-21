package JZ.topic2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * <p>
 * ArrayList， 底层是数组，查找时间复杂度为O(1)，添加删除为O(n)
 * LinkedList，底层是链表，查找时间复杂度为O(n)，添加删除为O(1)
 * <p>
 * LinkedList中poll和pop的区别：它们都是删除LinkedList中的第一个元素
 * poll 是基于队列结构实现的方法，当队列中没有元素时，调用该方法返回 null
 * pop  是基于栈结构实现的方法，当栈中没有元素时，调用该方法会发生异常
 */

public class T_22_PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            res.add(node.val);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
        return res;
    }

    //如果要求每层节点分类存储
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int level = 0;
        while (!list.isEmpty()) {
            res.add(new ArrayList<>());
            int len = list.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = list.pop();
                res.get(level).add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        T_22_PrintFromTopToBottom t = new T_22_PrintFromTopToBottom();
        ArrayList<ArrayList<Integer>> res = t.levelOrder(root);
        System.out.println(res);
    }
}
