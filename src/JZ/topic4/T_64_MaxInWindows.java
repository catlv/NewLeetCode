package JZ.topic4;

import java.util.ArrayList;
import java.util.LinkedList;

public class T_64_MaxInWindows {
    //滑动窗口类型的题，最佳解法是双端队列
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size < 1) {
            return res;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() != null && queue.peekFirst() + size == i) {
                queue.pollFirst();
            }
            if (queue.peekFirst() != null && i >= size - 1) {
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }

    //暴力解法，不推荐
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if (size == 0 || len < size) {
            return res;
        }
        for (int i = 0; i <= len - size; i++) {
            int max = num[i];
            for (int j = i + 1; j < size + i; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            res.add(max);
        }
        return res;
    }
}
