package topic81_100;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 */
public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p = res;

        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int v = p.next.val;
                while (p.next != null && p.next.val == v) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return res.next;
    }
}
