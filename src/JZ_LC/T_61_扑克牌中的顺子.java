package JZ_LC;

import java.util.Arrays;

/**
 * 对数组排序后，大小王，也就是0，就都在前面了，这些0可以为任意值，并且可以随意插入来让数组成为顺子。
 * 所以首先统计出0的个数，然后后面对这个有序数组进行判断时，i位置的数只会小于等于i+1位置的数
 * 如果等于，则不会为顺子，直接return false
 * 如果小于，则计算它们直接的差值，差值为1则没事，不用在dif里进行累加，差值为2和2以上，则需要进行累加了
 * 最后通过0的个数和差值dif的值来判断是否为顺子
 */
public class T_61_扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        if (nums.length != 5) {
            return false;
        }
        Arrays.sort(nums);
        int zero = 0;
        int dif = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            dif += nums[i + 1] - nums[i] - 1;
        }
        return zero >= dif;
    }
}
