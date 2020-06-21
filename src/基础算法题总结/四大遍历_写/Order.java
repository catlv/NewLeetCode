package 基础算法题总结.四大遍历_写;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Order {
    public void preOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            head = s.pop();
            System.out.println(head.val);
            if (head.right != null) {
                s.push(head.right);
            }
            if (head.left != null) {
                s.push(head.left);
            }
        }
    }

    public void inOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        while (!s.isEmpty() || head != null) {
            if (head != null) {
                s.push(head);
                head = head.left;
            } else {
                head = s.pop();
                System.out.println(head.val + " ");
                head = head.right;
            }
        }
    }

    public void postOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().val + " ");
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(Node head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(head);
        int level = 0;
        while (!list.isEmpty()) {
            res.add(new ArrayList<>());
            int len = list.size();
            for (int i = 0; i < len; i++) {
                Node node = list.pop();
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

    /**
     * 递归思路
     */
    public void preOrderR(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val + " ");
        preOrderR(head.left);
        preOrderR(head.right);
    }

    public void inOrderR(Node head) {
        if (head == null) {
            return;
        }
        inOrderR(head.left);
        System.out.println(head.val + " ");
        inOrderR(head.right);
    }

    public void postOrderR(Node head) {
        if (head == null) {
            return;
        }
        postOrderR(head.left);
        postOrderR(head.right);
        System.out.println(head.val + " ");
    }
}
