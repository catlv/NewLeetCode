package topicPlus;

public class LC876 {
    public ListNode middleNode(ListNode head) {
        ListNode l = head;
        ListNode r = head;
        while (r != null && r.next != null) {
            l = l.next;
            r = r.next.next;
        }
        return l;
    }
}
