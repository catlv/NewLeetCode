package topic21_40;

/**
 * 方法二：分治法
 * 先合并前一半数量的链表，再合并后一半数量的链表，最后合并到一起
 * O(klogk)   O(1)
 */
public class LC23_e {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l >= r) {
            return lists[l];
        }
        int mid = l + ((r - l) >> 1); //注意：需要打括号
        ListNode p1 = merge(lists, l, mid);
        ListNode p2 = merge(lists, mid + 1, r);
        return mergeTwo(p1, p2);
    }

    private ListNode mergeTwo(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwo(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwo(p1, p2.next);
            return p2;
        }
    }

//    private ListNode mergeTwo(ListNode p1, ListNode p2) {
//        ListNode head = new ListNode(0);
//        ListNode pre = head;
//        while (p1 != null && p2 != null) {
//            if (p1.val < p2.val) {
//                pre.next = p1;
//                p1 = p1.next;
//                pre = pre.next;
//            } else {
//                pre.next = p2;
//                p2 = p2.next;
//                pre = pre.next;
//            }
//        }
//        pre.next = p1 == null ? p2 : p1;
//        return head.next;
//    }
}
