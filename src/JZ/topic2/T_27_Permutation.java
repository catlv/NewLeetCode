package JZ.topic2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。（存在重复字符）
 */
public class T_27_Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0) {
            return res;
        }
        char[] c = str.toCharArray();
        Arrays.sort(c);
        helper(res, c, new StringBuilder(), new boolean[c.length]);
        return res;
    }

    private void helper(ArrayList<String> res, char[] c, StringBuilder s, boolean[] used) {
        if (s.length() == c.length) {
            res.add(s.toString());
            return;
        }
        for (int i = 0; i < c.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && c[i] == c[i - 1] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            s.append(c[i]);
            helper(res, c, s, used);
            s.deleteCharAt(s.length() - 1);
            used[i] = false;
        }
    }
}
