package JZ.topic2;

import java.util.LinkedList;

public class T_26_Convert_Queue {
    public TreeNode Convert(TreeNode pRootOfTree) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        inOrderToQueue(pRootOfTree, queue); //将二叉树按中序遍历存到队列中
        if (queue.isEmpty()) {
            return pRootOfTree;
        }
        pRootOfTree = queue.poll();
        TreeNode pre = pRootOfTree;
        pre.left = null;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return pRootOfTree;
    }

    private void inOrderToQueue(TreeNode pRootOfTree, LinkedList<TreeNode> queue) {
        if (pRootOfTree == null) {
            return;
        }
        inOrderToQueue(pRootOfTree.left, queue);
        //当队列为空时使用add会报错，使用offer会返回false。一般是作为queue使用时采用offer，作为list使用时采用add
        queue.offer(pRootOfTree);
        inOrderToQueue(pRootOfTree.right, queue);
    }
}
