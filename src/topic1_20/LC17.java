package topic1_20;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码中每个数字都对于这3-4个字母，0除外。
 * 给定仅包含数字2-9的字符串，返回它所能表示的字母组合。
 * 思路：回溯法深度优先遍历
 */
public class LC17 {
    public List<String> letterCombinations(String digits) {
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        char[] ds = digits.toCharArray();
        dfs(0, ds, new StringBuilder(), res, str);
        return res;
    }

    private void dfs(int i, char[] ds, StringBuilder cur, ArrayList<String> res, String[] str) {
        if (i == ds.length) { //对于 char[] ds， ds.length 不带[].
            res.add(cur.toString());
            return;
        }
        for (char c : str[ds[i] - '0'].toCharArray()) {
            cur.append(c);
            dfs(i + 1, ds, cur, res, str);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
