package JZ_LC;

import java.util.Arrays;

public class T_45_把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        //x+y 比 y+x 小，就把 x 放在 y 的前面
        //x+y 比 y+x 大，就把 y 放在 x 的前面
        Arrays.sort(s, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String str : s) {
            res.append(str);
        }
        return res.toString();
    }
}
