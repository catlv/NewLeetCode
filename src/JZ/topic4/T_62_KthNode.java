package JZ.topic4;

import java.util.Stack;

public class T_62_KthNode {
    int count = 0;
    //递归，中序遍历
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            count++;
            if (count == k) {
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }

    //非递归，中序遍历
    TreeNode KthNode2(TreeNode pRoot, int k) {
        if (pRoot != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || pRoot != null) {
                if (pRoot != null) {
                    stack.push(pRoot);
                    pRoot = pRoot.left;
                } else {
                    pRoot = stack.pop();
                    count++;
                    if (count == k) {
                        return pRoot;
                    }
                    pRoot = pRoot.right;
                }
            }
        }
        return null;
    }
}