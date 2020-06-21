package topic41_60;
/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 输入: "Hello World"
 * 输出: 5
 */
public class LC58 {
    public int lengthOfLastWord(String s) {
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }
        int end = p;
        while (p >= 0 && s.charAt(p) != ' ') {
            p--;
        }
        return end - p;
    }
}
