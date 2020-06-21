package topic201_300;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LC300 {
    /**
     * 动态规划：时间复杂度O(n^2)，空间复杂度O(n)
     * 1.定义数组元素的含义：dp[i]表示以i结尾的最长上升子序列长度。
     * 2.找出关系式：if nums[i] > nums[j]  则 dp[i] = Math.max(dp[i], dp[j] + 1);
     * 3.找出初始值：dp[i] 所有元素置为 1，因为每个元素都至少可以单独成为子序列，此时长度都为 1。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); //将数组中所有元素都置为1
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
