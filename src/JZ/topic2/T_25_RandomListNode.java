package JZ.topic2;

/**
 * 复杂链表的复制
 */
public class T_25_RandomListNode {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode temp;
        //复制原本的节点，生成 1 -> 1' -> 2 -> 2'-> 3 -> 3'
        while (cur != null) {
            temp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = temp;
            cur = temp;
        }

        //复制原来节点的random指针
        //把cur的random的next赋值给cur的next的random
        //   1     3     3'        1    1'
        cur = pHead;
        while (cur != null) {
            temp = cur.next.next;
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = temp;
        }

        //拆分，将 1和1'、2和2'、3和3' 拆开，得到复制的链表
        cur = pHead;
        RandomListNode curCopy;
        RandomListNode res = pHead.next;
        while (cur != null) {
            temp = cur.next.next;
            curCopy = cur.next;
            curCopy.next = temp != null ? temp.next : null;
            cur.next = temp;
            cur = temp;
        }
        return res;
    }
}

class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int label) {
        this.label = label;
    }
}