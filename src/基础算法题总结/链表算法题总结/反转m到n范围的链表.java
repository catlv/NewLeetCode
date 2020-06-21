package 基础算法题总结.链表算法题总结;

/**
 * 1 <= m <= n <= 链表长度
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class 反转m到n范围的链表 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (m > 1) {
            pre = cur; //pre指向反转范围的前一个节点，也就是例子中的 1
            cur = cur.next; //cur指向反转范围的第一个节点，也就是例子中的 2
            m--;
            n--;
        }
        ListNode l = pre; //l记下反转范围的前一个节点
        ListNode tail = cur; //tail记下反转范围的第一个节点，反转后tail位置变为反转范围反转后的最后一个节点
        ListNode next;
        while (n > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        tail.next = cur; //反转后，cur位置为反转范围右边第一个节点，也就是例子中的 5
        if (l != null) {
            l.next = pre;
        } else {
            head = pre;
        }
        return head;
    }
}
