package topic21_40;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 方法一：贪心算法+优先队列（时间复杂度没有分治法的好）
 */
public class LC23 {
    //方法一：贪心算法+优先队列
    //每次从优先队列中选出一个最小节点的时间复杂度是O(logk)
    //k个链表的节点总数为N，所以整体的时间复杂度是 Nlogk
    //优先队列需要用到k个空间，所以空间复杂度为 O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //优先队列默认是建立小根堆
        //由于比较的是节点的val值，所以 Comparator.comparingInt(a -> a.val)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            cur = cur.next;
            if (cur.next != null) {
                minHeap.add(cur.next);
            }
        }
        return res.next;
    }
}
