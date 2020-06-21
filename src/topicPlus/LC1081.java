package topicPlus;

/**
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 *
 * 贪心算法，待整理
 */
public class LC1081 {
    public String smallestSubsequence(String text) {
        if (text.isEmpty())
            return "";
        int[] zimuN = new int[26];
        for (int i = 0; i < text.length(); i++)
            zimuN[text.charAt(i) - 'a']++;
        char minChar = 'z';
        int minIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) < minChar) {
                minChar = text.charAt(i);
                minIndex = i;
            }
            if (--zimuN[text.charAt(i)-'a'] == 0) {
                return minChar
                        + smallestSubsequence(text.substring(minIndex)
                        .replaceAll(minChar + "", ""));
            }
        }
        return "";
    }
}
