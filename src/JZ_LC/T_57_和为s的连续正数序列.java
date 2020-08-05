package JZ_LC;

import java.util.ArrayList;

public class T_57_和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        int l = 1;
        int r = 2;
        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum > target) {
                l++;
            } else if (sum < target) {
                r++;
            } else {
                int[] temp = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    temp[i - l] = i;
                }
                res.add(temp);
                //注意这里要r++
                r++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
