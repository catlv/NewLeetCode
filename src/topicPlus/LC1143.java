package topicPlus;

/**
 * dp[i][j]表示s1...si和t1...tj之间的最长公共子序的长度
 * s1...si+1 和 t1...tj+1 的公共子序的长度分两种情况考虑：
 * 1.si+1 == tj+1，即 text1.charAt(i) == text2.charAt(j)，则 dp[i+1][j+1] = dp[i][j] + 1
 * 2.si+1 不等于 tj+1，则 dp[i+1][j+1] = Math.max(dp[i][j + 1], dp[i + 1][j])
 */
public class LC1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
