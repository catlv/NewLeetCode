package JZ_LC;

import java.util.PriorityQueue;

/**
 * java中的优先队列默认是小根堆
 */
public class T_40_最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        //不能忘
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (x, y) -> y.compareTo(x));
        for (int a : arr) {
            if (maxHeap.size() < k) {
                maxHeap.add(a);
            } else if (maxHeap.peek() > a) {
                maxHeap.poll();
                maxHeap.add(a);
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int j : maxHeap) {
            res[i++] = j;
        }
        return res;
    }
}
