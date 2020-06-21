package JZ.topic1;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class T_15_ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
