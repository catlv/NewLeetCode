package topicPlus;

/**
 * 大小为 K 且平均值大于等于阈值的子数组数目
 * <p>
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。(子数组意味着是连续的)
 *
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
 */
public class LC1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int res = 0;
        int sumTarget = k * threshold;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int temp = sum - sumTarget;
        if (temp >= 0) {
            res++;
        }
        int pos = k;
        for (int i = 0; i < arr.length - k; i++) {
            temp += arr[pos] - arr[i];
            if (temp >= 0) {
                res++;
            }
            pos++;
        }
        return res;
    }
}