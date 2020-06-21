package topicPlus;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 思路：
 * 1.dp[i] 表示和为 i 的组合数
 * 2.关系式：dp[ i ] = dp[ i - nums[0] ] + dp[ i - nums[1] ] + ... dp[ i - nums[len-1] ] ，条件为 i >= nums[j]
 * 3.dp[0] = 1,dp[0]表示组成0，一个数都不选就可以了，所以dp[0]=1
 */
public class LC377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] = dp[i] + dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
