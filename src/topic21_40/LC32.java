package topic21_40;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 思路：
 * dp[i]表示以字符串s中第i个字符结尾的有效括号的最长子串的长度。
 * （1）如果 s.charAt(i) == '('，有效括号是不可能以'('结尾，所以 dp[i] = 0。
 * （2）如果 s.charAt(i) == ')'，
 * 如果 s.charAt(i - 1) == '('，则 dp[i] = 2 + dp[i - 2]。
 * 如果 s.charAt(i - 1) == ')'，则 dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
 * dp[i - dp[i - 1] - 2] 代表的是以字符串s中第 i - dp[i - 1] - 2 个字符结尾的有效括号的最长子串的长度。
 * 时间复杂度：O(n)。遍历整个字符串一次，就可以将 dp 数组求出来。
 * 空间复杂度：O(n)。需要一个大小为 n 的 dp 数组。
 */
public class LC32 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
