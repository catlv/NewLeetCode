package 面试题;

public class LC52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int lenC = Math.abs(lenA - lenB);
        ListNode a = headA;
        ListNode b = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenC; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < lenC; i++) {
                b = b.next;
            }
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    public int getLen(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }
}
