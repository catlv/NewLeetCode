package JZ.topic4;

import java.util.PriorityQueue;

public class T_63_GetMedian {
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
    int count = 0;

    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 1) { //(count & 1) == 0为偶数，(count & 1) == 1为奇数
            leftMaxHeap.add(num);
            rightMinHeap.add(leftMaxHeap.poll());
        } else {
            rightMinHeap.add(num);
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public Double GetMedian() {
        if ((count & 1) == 0) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        } else {
            return (double) rightMinHeap.peek();
        }
    }
}