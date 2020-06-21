package JZ.topic2;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 解答：常规解法，采用中序遍历的非递归法，顺带复习中序遍历的非递归写法
 * 每次记录上一个访问的结点pre，然后每次当前结点为空(访问到了最左边)的时候，就设置pre和cur的关系即可；
 */

import java.util.Stack;

public class T_26_a {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        TreeNode res = null;
        boolean isFirst = true; //标注双向链表的开始位置
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else { //到达最左下位置，也就是双向链表的开始位置
                cur = s.pop();
                if (isFirst) {
                    isFirst = false;
                    res = cur;
                    pre = cur;
                } else { //后续就没 isFirst、res 的事了
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return res;
    }
}
