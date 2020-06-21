package JZ.topic1;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class T_14_FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
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
}
