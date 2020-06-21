package JZ.topic3;

/**
 * 句子里单词顺序翻转，单词本身不变。I am a student.” 翻转为 “student. a am I”。
 */
public class T_44_ReverseSentence {
    public String ReverseSentence(String str) {
        if (str.trim().length() == 0) {
            return str;
        }
        String[] word = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = word.length - 1; i > 0; i--) {
            res.append(word[i]).append(" "); //注意写法
        }
        res.append(word[0]);
        return res.toString();
    }
}
