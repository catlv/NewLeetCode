package topic41_60;

import java.util.ArrayList;

/**
 * 给定一个没有重复数字的字符串，返回其所有可能的全排列。
 */
public class LC46_String {
    public ArrayList<String> permuteUnique(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        helper(res, new StringBuilder(), chars);
        return res;
    }

    private void helper(ArrayList<String> res, StringBuilder s, char[] chars) {
        if (s.length() == chars.length) {
            res.add(s.toString());
            return;
        }
        for (char c : chars) {
            if (s.toString().contains(String.valueOf(c))) {
                continue;
            }
            s.append(c);
            helper(res, s, chars);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        LC46_String t = new LC46_String();
        String str = "abc";
        ArrayList<String> res = t.permuteUnique(str);
        System.out.println(res);
    }
}
