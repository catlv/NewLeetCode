package JZ_LC;

import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue;
    LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>(); //LinkedList是双端链表
    }

    public int max_value() {
        return max.size() == 0 ? -1 : max.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (max.size() != 0 && max.peekLast() < value) { //注意：这里第二个判断条件不能带等号，即max中对于当前queue中的具有相同值的元素会全部存储，而不是存储最近的那个。
            max.pollLast();
            //也可以用max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        //这里需要弹出原本队列的队头，如果这个队头是最大值，那么弹出后，后面计算最大值时就不能考虑它了
        //所以如果队列的队头等于max的第一个元素，max就要移除这个元素
        if (max.size() != 0 && queue.peek().equals(max.peekFirst()))//Integer类型的值的比较不能直接使用==
            max.pollFirst();
        return queue.size() == 0 ? -1 : queue.poll();
    }
}
