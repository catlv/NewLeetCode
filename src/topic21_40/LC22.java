package topic21_40;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表括号的对数，写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 思路：回溯法（深度优先遍历）
 */
public class LC22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    private void helper(ArrayList<String> res, String s, int l, int r, int n) {
        if (r == n) {
            res.add(s);
            return;
        }
        if (l < n) {
            helper(res, s + "(", l + 1, r, n);
        }
        if (r < l) {
            helper(res, s + ")", l, r + 1, n);
        }
    }
}
