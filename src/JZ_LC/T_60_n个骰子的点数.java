package JZ_LC;

/**
 * dp[i][j] 代表投i枚骰子和为j的概率
 * n <= j <= 6n
 */
public class T_60_n个骰子的点数 {
    public double[] twoSum(int n) {
        if (n == 0) {
            return new double[0];
        }
        //注意：对于for循环中，j=1开始，条件为j<=6 这种类型的，在new数组的时候，大小要+1 !!!
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1.0 / 6.0;
        }
        for (int i = 2; i <= n; i++) { //i表示骰子个数
            for (int s = i; s <= i * 6; s++) { //s表示点数，这里注意s的初始值为i，而不是n
                for (int j = 1; j <= 6 && j < s; j++) { //j表示当前骰子的点数
                    dp[i][s] += dp[i - 1][s - j] * 1.0 / 6.0;
                }
            }
        }
        //最大值为6n，最小值为n，所以中间总共有 5n+1 个数
        double[] res = new double[6 * n - n + 1];
        System.arraycopy(dp[n], n, res, 0, res.length);
        return res;
    }
}
