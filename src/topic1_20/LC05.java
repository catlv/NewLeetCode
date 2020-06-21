package topic1_20;

/**
 * 找到最长的回文子串
 * Input: "babad"
 * Output: "bab"
 * Note: "aba"
 * <p>
 * 定义 dp[j][i] 的意思为字符串区间 [j, i] 是否为回文串，由此分为三种情况：
 * 1.当 i == j 时，那么 dp[i][j] = true；
 * 2.当 i + 1 == j 时，那么 dp[i][j] 的值取决于 s[i] == s[j]；
 * 3.当 i + 1 < j 时，那么 dp[i][j] 的值取决于 dp[i + 1][j - 1] && s[i] == s[j]。
 */
public class LC05 {
    //dp法：时间复杂度和空间复杂度都是O(n²)
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int start = 0, end = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else { // i + 1 < j
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        //substring 包含 start，不包含 end + 1
        return s.substring(start, end + 1);
    }

    //中心扩展法，时间复杂度：O(n²); 空间复杂度：O(1)
    public String longestPalindrome2(String s) {
        //最后有 s.substring 方法，对于此方法 s.length() 不能为0
        if (s.length() == 0) {
            return s;
        }
        int start = 0;
        int end = 0;

        //选择一个字符为中心，往两边扩展，有n个中心
        //选择两个字符为中心，往两边扩展，有n-1个中心
        for (int i = 0; i < s.length(); i++) {
            int len1 = helper(s, i, i); //以i为中心
            int len2 = helper(s, i, i + 1); //以i和i+1为中心
            int len = Math.max(len1, len2);
            if (len >= end - start + 1) {
                //可以举例子来确定
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // (right-1) - (left+1) + 1
    }
}
