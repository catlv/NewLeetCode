package topic1_20;

/**
 * 查找字符串数组中的最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 注意：String[] strs ，求它的长度时，不带括号：strs.length 。
 */
public class LC14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        for (int i = 0; i < minLen; i++) { //一列一列的来比较
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}
