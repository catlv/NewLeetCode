package JZ_LC;

import java.util.Arrays;
import java.util.LinkedList;

public class T_38_字符串的排列 {
    public String[] permutation(String s) {
        LinkedList<String> list = new LinkedList<>();
        if (s.length() == 0) {
            return new String[0];
        }
        char[] c = s.toCharArray();
        Arrays.sort(c);
        helper(list, new StringBuilder(), c, new boolean[c.length]);
        return list.toArray(new String[0]);
    }

    private void helper(LinkedList<String> list, StringBuilder s, char[] c, boolean[] used) {
        if (s.length() == c.length) {
            list.add(s.toString());
            return;
        }
        for (int i = 0; i < c.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && c[i - 1] == c[i] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            s.append(c[i]);
            helper(list, s, c, used);
            s.deleteCharAt(s.length() - 1);
            used[i] = false;
        }
    }
}
