package topic41_60;

import java.util.ArrayList;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123","132","213","231","312","321"
 * 给定 n 和 k，返回第 k 个排列。
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1, n!]。
 */
public class LC60 {
    public String getPermutation(int n, int k) {
        ArrayList<String> res = new ArrayList<>();
        helper(n, res, new StringBuffer());
        return res.get(k - 1);
    }

    private void helper(int n, ArrayList<String> res, StringBuffer s) {
        if (s.length() == n) {
            res.add(s.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (s.toString().contains(i + "")) {
                continue;
            }
            s.append(i);
            helper(n, res, s);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        LC60 t = new LC60();
        int n = 3;
        int k = 6;
        String res = t.getPermutation(n, k);
        System.out.println(res);
    }
}
