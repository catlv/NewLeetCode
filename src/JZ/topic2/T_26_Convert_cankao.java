package JZ.topic2;

/**
 * first表示将二叉搜索树转为双向链表后的第一个节点
 * tail表示转换后最后一个节点
 */
public class T_26_Convert_cankao {
    private TreeNode first = null;
    private TreeNode tail = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convertSub(pRootOfTree);
        return first;
    }

    private void convertSub(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        convertSub(pRootOfTree.left);
        if (tail == null) {
            first = pRootOfTree;
            tail = pRootOfTree;
        } else { //将根节点加入双向链表中
            tail.right = pRootOfTree;
            pRootOfTree.left = tail;
            tail = pRootOfTree;
        }
        convertSub(pRootOfTree.right);
    }
}

