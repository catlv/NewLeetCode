package 基础算法题总结.链表算法题总结;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {
    public ArrayList<Integer> printFromTailToHead(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        Stack<Integer> s = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            s.push(cur.val);
            cur = cur.next;
        }
        while (!s.isEmpty()) {
            res.add(s.pop());
        }
        return res;
    }
}
