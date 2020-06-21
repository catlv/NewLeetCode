package topic1_20;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 思路：双指针法
 * 倒数第一个节点下标为len-1，倒数第n个节点下标为len-n，相隔n-1
 * 所以，如果要找到倒数第n个节点，则快指针要提前先走n-1步，这样才能保持相隔n-1
 * 此题是要删除第n个节点，所以要找到的是倒数第n-1个节点，与倒数第一个节点相隔n
 * 所以此处快指针要提前先走n步，这样才能保持相隔n
 */
public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode l = pre;
        ListNode r = pre;
        for (int i = 0; i < n; i++) {
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
