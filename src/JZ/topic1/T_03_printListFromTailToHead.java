package JZ.topic1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * 将链表转为ArrayList反向输出，可以采用栈来实现，首先将链表listNode的每个节点存入栈中，
 * 这个过程要注意：存进栈的不是节点，而是节点的值，所以有了 stack.push(listNode.val)
 */
public class T_03_printListFromTailToHead {
    //递归
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    //非递归
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list2 = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list2.add(stack.pop());
        }
        return list2;
    }
}
