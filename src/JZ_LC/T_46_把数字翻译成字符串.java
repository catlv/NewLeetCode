package JZ_LC;

/**
 * 动态规划
 * 这里要注意理清楚状态转移方程
 * i-1和i位置组合出来的数，如果大于9小于26，那么i位置的数就有两种情况：
 * dp[i] = dp[i-1] + dp[i-2];
 */
public class T_46_把数字翻译成字符串 {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        char[] c = String.valueOf(num).toCharArray();
        int[] dp = new int[c.length];
        dp[0] = 1;
        int n = (c[0] - '0') * 10 + (c[1] - '0');
        dp[1] = n > 9 && n < 26 ? 2 : 1;
        for (int i = 2; i < c.length; i++) {
            n = (c[i - 1] - '0') * 10 + (c[i] - '0');
            if (n > 9 && n < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[c.length - 1];
    }
}
