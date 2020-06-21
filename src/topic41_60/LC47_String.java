package topic41_60;
/**
 * 给定一个有重复数字的字符串，返回其所有可能的全排列。
 * 回溯法
 */
import java.util.ArrayList;
import java.util.Arrays;

public class LC47_String {
    public ArrayList<String> permute(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper(res, new StringBuilder(), chars, new boolean[chars.length]);
        return res;
    }

    private void helper(ArrayList<String> res, StringBuilder s, char[] chars, boolean[] used) {
        if (s.length() == chars.length) {
            res.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            s.append(chars[i]);
            helper(res, s, chars, used);
            s.deleteCharAt(s.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        LC47_String t = new LC47_String();
        String str = "abc";
        ArrayList<String> res = t.permute(str);
        System.out.println(res);
    }
}
