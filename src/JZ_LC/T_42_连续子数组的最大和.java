package JZ_LC;

/**
 * dp[i]表示以i位置结尾的子数组的最大值
 */
public class T_42_连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
