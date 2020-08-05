package JZ_LC;

/**
 * trim 的作用是删除首尾空格
 */
public class T_58_翻转单词顺序 {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        String[] word = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) {
            //注意：trim只是删除了首尾空格，内部单词间的空格并没有删除
            //所以通过split进行划分的时候，内部的空格也会参与划分，划分到word中的样子是""，空字符串，而不是 " " 空格字符串。
            if (word[i].equals("")) {
                continue;
            }
            res.append(word[i]).append(" ");
        }
        return res.toString().trim();
    }
}
