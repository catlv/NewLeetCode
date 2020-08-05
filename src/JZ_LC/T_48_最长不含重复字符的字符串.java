package JZ_LC;

import java.util.HashMap;
import java.util.Map;


public class T_48_最长不含重复字符的字符串 {
    /**
     * 指针 j 遍历字符 s ，哈希表统计字符 s[j] 最后一次出现的索引 。
     * 根据上轮左指针 i 和 dic[s[j]] ，每轮更新左边界 i ，保证区间 [i + 1, j] 内无重复字符且最大:
     * i = max(dic[s[j]],i)
     * 取上轮 res 和本轮双指针区间 [i + 1,j] 的宽度（即 j - i）中的最大值:
     * res = max(res,j−i)
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));  // 更新左指针 i
            }
            map.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }


    /**
     * 动态规划
     * Map中的val统计的是各字符最后一次出现的索引位置
     * dp[i]表示以字符s[i]结尾的最长不重复子字符串的长度
     * 当 i < 0 ，即 s[j] 左边无相同字符，则 dp[j] = dp[j-1] + 1
     * 当 dp[j - 1] < j - i，说明字符 s[i] 在子字符串 dp[j-1] 区间之外 ，则 dp[j] = dp[j - 1] + 1
     * 当 dp[j−1] >= j − i ，说明字符 s[i] 在子字符串 dp[j-1] 区间之中 ，则 dp[j] 的左边界由 s[i] 决定，即 dp[j] = j - i
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        ans = 1;
        map.put(s.charAt(0), 0);
        for (int j = 1; j < s.length(); j++) {
            //v得到的是从s[i]往左看，第一个等于s[i]的字符的下标值
            int v = map.get(s.charAt(j));
            //如果map中确实有这个下标值，表示这个值之前出现过了，令i等于这个下标值即可
            int i = map.containsValue(v) ? v : -1;
            //更新map
            map.put(s.charAt(j), j);
            dp[j] = dp[j - 1] < j - i ? dp[j - 1] + 1 : j - i;
            ans = Math.max(dp[j], ans);
        }
        return ans;
    }
}
