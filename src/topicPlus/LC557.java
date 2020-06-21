package topicPlus;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 */
public class LC557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            //StringBuilder 的 append 方法输入的是String类型
            //StringBuilder 内部有 reverse 方法
            res.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        return res.toString().trim(); //trim 表示去掉字符串两端的多余空格
    }
}
