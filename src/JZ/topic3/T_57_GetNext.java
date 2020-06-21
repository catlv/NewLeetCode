package JZ.topic3;

public class T_57_GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            TreeLinkNode parent = pNode.next;
            while (parent != null && parent.left != pNode) {
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
