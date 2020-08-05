package JZ_LC;

/**
 * 动态规划
 * 设dp[i] 为以 prices[i] 结尾的子数组的最大利润，也就是前i日的最大利润
 * 初始值为 dp[0] = 0
 * 状态转移方程为：dp[i] = Math.max(dp[i - 1], prices[i] - 前i-1日的价格最小值)
 */
public class T_63_股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) { //这里的判断不能忘
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minTemp = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minTemp = Math.min(minTemp, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minTemp);
        }
        return dp[prices.length - 1];
    }
}
