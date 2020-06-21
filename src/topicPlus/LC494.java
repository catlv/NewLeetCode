package topicPlus;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 思路：
 * 所有使用‘+’的数的和：sum(P)；所有使用‘-’的数的和：sum(N)
 * 则：sum(p) - sum(N) = target;
 * 则：sum(p) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N);
 * 则：2 * sum(P) = target + sum;  (此处sum表示所有这些非负整数的和)
 * 则：sum(P) = (target + sum) / 2 ;
 *
 * 因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
 * 1.定义 dp[i] 表示和为 i 的方法数。
 * 2.关系式：dp[i] = dp[i] + dp[i-num]; (不放num进背包，解法为dp[i]；放num进背包，解法为dp[i-num])
 * 3.初始化 dp[0] = 1;
 */
public class LC494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        target = (target + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                dp[i] = dp[i] + dp[i - n];
            }
        }
        return dp[target];
    }
}
