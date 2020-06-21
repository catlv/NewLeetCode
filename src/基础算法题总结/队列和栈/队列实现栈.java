package 基础算法题总结.队列和栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈的思路：构建两个队列：Data队列和help队列；压入数据时数据都进Data队列，假设队列中按顺序进入了1，2，3，4，5，返回数据时，把1，2，3，4 放入help队列，然后拿出Data中的5返回；接着改引用，将Data队列和help队列的引用交换；下次返回数据时就依然是把Data队列中的123放入help队列，然后拿出Data队列中的4返回，再交换两队列的引用，如此反复。
 *
 * 栈用pop，队列用poll
 */
public class 队列实现栈 {
    public class TwoQueues_Stack {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> helper = new LinkedList<>();

        public void push(int p) {
            queue.add(p);
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() != 1) {
                helper.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() != 1) {
                helper.add(queue.poll());
            }
            int res = queue.poll();
            helper.add(res);
            swap();
            return res;
        }

        public void swap() {
            Queue<Integer> temp = helper;
            helper = queue;
            queue = temp;
        }
    }
}
