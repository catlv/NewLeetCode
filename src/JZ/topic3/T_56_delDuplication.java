package JZ.topic3;

public class T_56_delDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode first = head;
        ListNode second = pHead;
        while (second != null) {
            if (second.next != null && second.val == second.next.val) {
                while (second.next != null && second.val == second.next.val) {
                    second = second.next;
                }
                first.next = second.next;
            } else {
                first = first.next;
            }
            second = second.next;
        }
        return head.next;
    }
}
