package JZ.topic3;

import java.util.ArrayList;

/**
 * 找出所有和为S的连续正数序列?
 * 双指针法
 */
public class T_41_FindSequenceEqualsSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l = 1;
        int r = 2;
        while (l < r) {
            int s = (l + r) * (r - l + 1) / 2;
            if (s == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                res.add(list);
                r++;
            } else if (s < sum) {
                r++;
            } else {
                l++;
            }
        }
        return res;
    }
}
