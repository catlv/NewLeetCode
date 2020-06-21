package JZ.topic2;

/**
 * 求最大连续子序列和
 *
 * 动态规划
 * 1.定义数组元素的含义：sum[i]从起点到i位置的最大和
 * 2.找出关系式：sum[i] = sum[i - 1] > 0 ? sum[i - 1] + array[i] : array[i];
 * 3.找出初始值：sum[0]=array[0];
 */
public class T_30_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
//        dp法：
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//        int[] dp = new int[array.length];
//        int res = array[0];
//        dp[0] = array[0];
//        for (int i = 1; i < array.length; i++) {
//            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + array[i] : array[i];
//            res = Math.max(res, dp[i]);
//        }
//        return res;

        //dp空间优化：将dp[i]和dp[i-1]改为 preMax
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = array[0];
        int preMax = 0;
        for (int a : array) {
            preMax = preMax > 0 ? preMax + a : a;
            res = Math.max(res, preMax);
        }
        return res;
    }
}