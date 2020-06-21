package topic201_300;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 思路：
 * 一.JDK自带的快速排序：Arrays.sort(nums) ，直接对整个数组全部快速排序，然后输出 len - k 的位置。
 * 二.改进快排(推荐)：不需要对整个数组全部快排，只需要一次次找最终位置，找到 len - k 位置时就停止。
 * 1.Math.random(), 生成 [0,1)之间的数，需要强制类型转换为 int。 (int) Math.random() * (right - left) + left;
 * 2.Random random = new Random();    random.nextInt(n) 生成 [0,n) 之间的数。
 * 三.优先队列
 */
public class LC215 {
    //一.JDK自带快排
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //二.改进快排（不排完、随机基准值）
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return left; //或right
    }

    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            Random random = new Random();
            int randomIndex = random.nextInt(right - left) + left;
            swap(nums, left, randomIndex);
        }
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //三.优先队列
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
