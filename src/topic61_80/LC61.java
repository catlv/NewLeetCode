package topic61_80;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 6
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 *
 * 对于1,2,3，移动1步，划分为 1,2  3 ，然后把3移到1,2的前面，形成312
 * 由于要把2后面设为null，所以需要找到2的位置（cur）
 * 将cur的下一位3设为头结点，然后将cur的next指向null
 */
public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        int count = 1;
        while (cur.next != null) { //计数，并找到最后一个节点
            cur = cur.next;
            count++;
        }
        cur.next = head;

        cur = head;
        for (int i = 1; i < count - (k % count); i++) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }
}
