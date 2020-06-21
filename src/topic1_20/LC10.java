package topic1_20;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class LC10 {
    public boolean isMatch(String s, String p) {
        //dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        //此处for循环表示s为空的情况
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
            //其他情况比如s=""，p="a" 时，直接到达最后 return dp[0][1] ，默认里面是false
        }

        //此处for循环表示s不为空的情况
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                //s和p最后一位匹配（p最后一位等于s最后一位，或者p最后一位为'.'）
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //s和p最后一位不匹配（p最后一位为'*'）
                if (p.charAt(j - 1) == '*') {
                    //p倒数第二位和s最后一位不匹配
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        //p倒数第二位和s最后一位匹配。此时有三种情况：
                        //1.p最后一位的'*'表示零个，dp[i][j]=dp[i][j-2]
                        //2.p最后一位的'*'表示一个，dp[i][j]=dp[i-1][j-2]
                        //3.p最后一位的'*'表示多个，dp[i][j]=dp[i-1][j]
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
