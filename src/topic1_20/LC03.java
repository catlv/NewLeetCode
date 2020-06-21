package topic1_20;

/**
 * 给定一个字符串，找到不重复字符的最长子字符串的长度。
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * 滑动窗口法：[i,j)
 */

import java.util.HashMap;
import java.util.HashSet;

public class LC03 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int[] window = new int[128];
        int res = 1;
        int l = 0;
        int r = 0;
        while (r < len) {
            char rightCur = s.charAt(r);
            window[rightCur]++;
            r++;
            while (window[rightCur] > 1) {
                char leftCur = s.charAt(l);
                window[leftCur]--;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    //HashSet
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i); //上面一步是j++，所以这里j-i不用再+1了
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //HashMap
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int res = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < n && j < n) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j++), j);
                res = Math.max(res, j - i); //上面一步是j++，所以这里j-i不用再+1了
            } else {
                map.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
