package topic81_100;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 :
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 思路一：递归
 * 对于第一个字母我们有两种划分方式。
 * 2|3223 和 23|223
 * 所以，如果我们分别知道了上边划分的右半部分 3223 的解码方式是 ans1 种，223 的解码方式是 ans2 种，那么整体 23223 的解码方式就是 ans1 + ans2 种。
 * <p>
 * 思路二：动态规划
 * dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的解码方式。
 * 如果 s [ i ] 和 s [ i + 1 ] 组成的数字小于等于 26，那么
 * dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
 */
public class LC91 {
    //动态规划
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            //如果该位不为'0'，说明该位单独成字母合法
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public int numDecodings_倒序(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                if ((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' <= 26) {
                    //如果i位置的数自己单独一位，则有 dp[i+1] 种情况
                    //如果i位置的数和后面一位合并，则有 dp[i+2] 种情况
                    //合起来便是下面的等式了
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else {
                    dp[i] = dp[i + 1];
                }
            }
        }
        return dp[0];
    }

    //递归法
    public int numDecodings2(String s) {
        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        //划分到了最后返回1
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;

        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }


}
