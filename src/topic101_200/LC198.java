package topic101_200;

/**
 * 给定一个代表每个房屋存放金额的非负整数数组，计算在不触动警报装置的情况下能够偷窃到的最高金额。
 * 两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * f(k) = 从 前k个房屋中能抢劫到的最大数额，Ai = 第 i 个房屋的钱数。
 * <p>
 * 首先看 n = 1 的情况，显然 f(1) = A1
 * 再看 n = 2，f(2) = max(A1,A2)
 * 对于 n = 3，有两个选项:
 * <p>
 * 抢第三个房子，将数额与第一个房子相加。
 * 不抢第三个房子，保持现有最大数额。
 * f(k) = max(f(k – 2) + Ak , f(k – 1))
 */
public class LC198 {
    public int rob(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int[] dp = new int[num.length];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);
        for (int i = 2; i < num.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
        }
        return dp[num.length - 1];
    }

    //空间优化
    public int rob2(int[] num) {
        int preMax = 0; // n=1
        int currMax = 0; // n=2
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(preMax + x, currMax); // n=3
            preMax = temp;
        }
        return currMax;
    }
}
