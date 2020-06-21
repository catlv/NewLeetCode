package topic101_200;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 思路：归并排序 O(nlogn)    O(1)
 * 找出链表中间位置：设置一个慢指针slow，一个快指针fast
 * 画图可知，fast != null 、fast.next != null 、fast.next.next == null 时
 * 还需要往后走一次，所以终止条件为 fast != null && fast.next != null
 *
 * 通过比较147的插入排序（n^2）和148的归并排序（nlogn），最好使用归并排序
 */
public class LC148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
