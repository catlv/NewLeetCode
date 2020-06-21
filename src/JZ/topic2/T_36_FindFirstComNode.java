package JZ.topic2;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * <p>
 * 此处给的方法没有考虑是否有环，一般面试考察都会有环，所以见下一个class文件
 */

public class T_36_FindFirstComNode {
    //HashSet法
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        for (ListNode cur = pHead1; cur != null; cur = cur.next) {
            set.add(cur);
        }
        for (ListNode cur = pHead2; cur != null; cur = cur.next) {
            if (set.contains(cur)) {
                return cur;
            }
        }
        return null;
    }

    /**
     * 1.求出两个链表的长度len1，len2
     * 2.记较长的链表为p1，较短的链表为p2
     * 3.先让p1走 abs(len1-len2) 步
     * 4.然后让p1、p2一起走，当 p1==p2 时，就是第一个公共节点
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        p1 = len1 > len2 ? pHead1 : pHead2;
        p2 = len1 > len2 ? pHead2 : pHead1;
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            p1 = p1.next;
        }
        while (p1 != p2 && p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //长度不同有公共结点，第一遍差值出来，第二遍一起到公共结点
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 != null ? p1.next : pHead2);
            p2 = (p2 != null ? p2.next : pHead1);
        }
        return p1;
    }
}
