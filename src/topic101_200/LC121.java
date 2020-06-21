package topic101_200;

/**
 * dp[i]表示前i天所能获得的最大利润
 */
public class LC121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < len; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > dp[i - 1]) {
                dp[i] = prices[i] - minPrice;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}

