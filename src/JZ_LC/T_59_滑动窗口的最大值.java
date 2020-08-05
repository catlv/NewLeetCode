package JZ_LC;

import java.util.LinkedList;

public class T_59_滑动窗口的最大值 {
    //单调双端队列（滑动窗口类型的最佳解法）
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>(); //双端队列，记录的是下标，而不是具体的值
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果队列尾部元素小于等于当前数组的元素，那么为了维持队列从大到小的原则，弹出队列尾部元素
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            //在队列尾部添加元素
            queue.addLast(i);
            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if (queue.peekFirst() != null && queue.peekFirst() + k == i) {
                queue.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if (queue.peekFirst() != null && i >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    //暴力解法，不推荐
    public int[] maxSlidingWindow2(int[] nums, int k) {
        //注意：如果if条件成立，返回的是[]，也就是长度为0的int[]
        if (k == 0 || nums.length < k) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }
}
