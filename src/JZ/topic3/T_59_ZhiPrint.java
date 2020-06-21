package JZ.topic3;

import java.util.ArrayList;
import java.util.Stack;

public class T_59_ZhiPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //设两个栈，s2存放偶数层，s1存放奇数层
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int flag = 1; //最开始从第一层奇数层开始
        if (pRoot == null) {
            return res;
        }
        s1.push(pRoot);
        ArrayList<Integer> temp = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (flag % 2 != 0) {
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    temp.add(node.val);
                    if (node.left != null) {
                        s2.push(node.left);
                    }
                    if (node.right != null) {
                        s2.push(node.right);
                    }
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if (node.right != null) {
                        s1.push(node.right);
                    }
                    if (node.left != null) {
                        s1.push(node.left);
                    }
                }
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
            flag++;
        }
        return res;
    }
}
