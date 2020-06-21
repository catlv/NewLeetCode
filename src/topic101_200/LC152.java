package topic101_200;

/**
 * 动态规划：
 * 定义数组 dpMax[i] 表示以第i个元素结尾的子数组中乘积最大的值，这个数组必须包含第i个元素
 * 对于 dpMax[i] 有三种取值：
 * 1. nums[i] >= 0 且 dpMax[i-1] > 0 , 则 dpMax[i] = dpMax[i-1] * nums[i]
 * 2. nums[i] >= 0 且dpMax[i-1] < 0，如果和前边的数累乘，会变成负数，所以dpMax[i] = nums[i]
 * 3. nums[i] < 0，如果前边累乘结果是一个很小的负数，那么和当前负数累乘的话就会变成一个很大的正数。
 * 所以还需要一个数组 dpMin 来记录以第 i 个元素结尾的子数组中乘积最小的值。
 * dpMin[i-1] < 0 时， dpMax[i] = dpMin[i-1] * nums[i]
 * dpMin[i-1] >= 0 时，dpMax[i] = nums[i]
 * <p>
 * 注意到上边 dpMax[i] 的取值无非就是三种，dpMax[i-1] * nums[i]、dpMin[i-1] * nums[i] 以及 nums[i]。
 * 所以我们更新的时候，无需去区分当前是哪种情况，只需要从三个取值中选一个最大的即可。
 * dpMax[i] = max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i]);
 * 同理可得：
 * dpMin[i] = min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i]);
 */
public class LC152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            max = Math.max(dpMax[i], max);
        }
        return max;
    }

    //dp空间优化
    public int maxProduct2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
            int preMax = dpMax;
            dpMax = Math.max(Math.max(dpMax * nums[i], dpMin * nums[i]), nums[i]);
            dpMin = Math.min(Math.min(preMax * nums[i], dpMin * nums[i]), nums[i]);
            max = Math.max(dpMax, max);
        }
        return max;
    }
}
