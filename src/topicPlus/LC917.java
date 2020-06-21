package topicPlus;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 */
public class LC917 {
    public String reverseOnlyLetters(String s) {
        StringBuilder res = new StringBuilder();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                while (!Character.isLetter(s.charAt(j))) {
                    j--;
                }
                res.append(s.charAt(j--));
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
