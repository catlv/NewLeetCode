package 基础算法题总结.链表算法题总结;

public class 链表倒数第k个节点 {
    //返回链表倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l = head;
        ListNode r = head;
        for (int i = 0; i < k; i++) {
            if (r != null) {
                r = r.next;
            } else {
                return null;
            }
        }
        while (r != null) {
            r = r.next;
            l = l.next;
        }
        return l;
    }

    //删除链表倒数第k个节点
    public ListNode removeKthFromEnd(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode l = pre;
        ListNode r = pre;
        for (int i = 0; i < k; i++) {
            if (r != null) {
                r = r.next;
            } else {
                return null;
            }
        }
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return pre.next;
    }
}
