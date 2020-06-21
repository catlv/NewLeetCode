package topicPlus;

import java.util.List;

/**
 * 给定一个字符串s，和一个字符串字典d，在d中找到一个最长的字符串，使它可以由s删除某些节点来得到
 * 如果答案不止一个，返回长度最长且字典序最小的那个字符串。
 * 方法：比较字符串字典序大小的方法是：a.compareTo(b) < 0 ，表示字符串a的字典序小于b。
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 输出:
 * "apple"
 */
public class LC524 {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }
        return res;
    }

    private boolean isSubsequence(String str, String s) {
        int i = 0;
        for (int j = 0; j < s.length() && i < str.length(); j++) {
            if (str.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        return i == str.length();
    }
}
