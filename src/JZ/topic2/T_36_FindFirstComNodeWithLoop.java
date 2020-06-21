package JZ.topic2;

/**
 * 输入两个链表，找出它们的第一个公共结点。（要考虑是否有环）
 *
 * getLoopNode：得到环的入口节点
 * noLoop：两链表都无环时的第一个公共节点
 * bothLoop：两链表都有环时的第一个公共节点
 */
public class T_36_FindFirstComNodeWithLoop {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode loop1 = getLoopNode(pHead1);
        ListNode loop2 = getLoopNode(pHead2);
        if (loop1 == null && loop2 == null) {
            return noLoop(pHead1, pHead2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(pHead1, loop1, pHead2, loop2);
        }
        return null;
    }

    //定义一个慢指针，一次走一步；和一个快指针，一次走两步
    //如果没有环，return null
    //如果有环，两指针一定会相遇。相遇后将快指针放在头结点处，然后也开始一次走一步
    //快慢指针再相遇时，所处的位置一定是环的入口处。
    private ListNode getLoopNode(ListNode pHead) {
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) { // 注意！！：此处都是 n2
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; //也可以填 fast
    }

    //如果题目不考虑环，可以直接写下面这个即可
    private ListNode noLoop(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int n = 0;
        while (p1.next != null) {
            p1 = p1.next;
            n++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            n--;
        }
        if (p1 != p2) {
            return null;
        }
        p1 = n > 0 ? pHead1 : pHead2;
        p2 = n > 0 ? pHead2 : pHead1;
        n = Math.abs(n);
        while (n != 0) {
            p1 = p1.next;
            n--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private ListNode bothLoop(ListNode pHead1, ListNode loop1, ListNode pHead2, ListNode loop2) {
        ListNode p1;
        ListNode p2;
        if (loop1 == loop2) { //（1）先相交，再共享同一个环，loop指的是环的入口处
            p1 = pHead1;
            p2 = pHead2;
            int n = 0;
            while (p1 != loop1) {
                p1 = p1.next;
                n++;
            }
            while (p2 != loop2) {
                p2 = p2.next;
                n--;
            }
            p1 = n > 0 ? pHead1 : pHead2;
            p2 = n > 0 ? pHead2 : pHead1;
            n = Math.abs(n);
            while (n != 0) {
                p1 = p1.next;
                n--;
            }
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        } else { //即 loop1!=loop2 的情况
            p1 = loop1.next;
            while (p1 != loop1) {
                if (p1 == loop2) { //（2）在环的某处相遇
                    return loop2; //此处填 loop1 loop2 都行
                }
                p1 = p1.next;
            }
            return null; //（3）各自成环
        }
    }
}
