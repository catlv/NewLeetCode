package topic101_200;

/**
 * 对链表进行插入排序 O(n^2)。 输入: 4->2->1->3 ，输出: 1->2->3->4
 * 思路： pre  pre.next        head   (head.next)cur
 *        2      9       10    15           8
 */
public class LC147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre;
        while (head != null && head.next != null) {
            if (head.val < head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;
            ListNode cur = head.next;
            while (pre.next.val < cur.val) {
                pre = pre.next;
            }
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }
}
