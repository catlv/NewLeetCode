package JZ.topic2;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
 * 2、定位到左链表的最后一个节点(左子树最右边的节点)
 * 3、如果左子树链表不为空，则将当前root追加到左子树链表后
 * 4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
 * 5、如果右子树链表不为空，将右子树链表追加到当前root后
 * 6，根据左子树链表是否为空，返回整体双向链表的头节点
 */

public class T_26_Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);

        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        TreeNode right = Convert(pRootOfTree.right);

        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
}
