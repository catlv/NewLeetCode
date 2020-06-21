package JZ.topic4;

import java.util.LinkedList;

public class T_61_Serialize {
    //序列化
    String Serialize(TreeNode root) {
        /*
          String res = root.val + "!";
          res += Serialize(root.left);
          res += Serialize(root.right);
          return res;

          上述方法也能实现，但是+=频繁的对字符串进行修改，而String是不可变的
          所以每次修改时都要在内存中创建一个新的字符串对象，并为它分配新的空间
          这样的话开销会很大。所以这里要用StringBuffer，它是可以改变的字符串
         */

        if (root == null) {
            return "#,";
        }
        StringBuffer res = new StringBuffer(root.val + ",");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();
    }

    //反序列化
    TreeNode Deserialize(String str) {
        String[] values = str.split(",");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : values) {
            queue.offer(s);
        }
        return recon(queue);
    }

    private TreeNode recon(LinkedList<String> queue) {
        String value = queue.poll(); //poll针对队列，pop针对栈
        if ("#".equals(value)) {
            return null;
        }
        TreeNode head = null;
        if (value != null) {
            head = new TreeNode(Integer.valueOf(value));
            head.left = recon(queue);
            head.right = recon(queue);
        }
        return head;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
