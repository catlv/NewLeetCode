package topicPlus;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 思路：假设有三种金额：2，3，7。dp[n]表示凑出金额n的最少硬币数量
 * 则 dp[n] = min { dp[n-2]，dp[n-3]，dp[n-7] } + 1
 */
public class LC322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c >= 0 && dp[i - c] != Integer.MAX_VALUE) { //判断是否可以凑成金额 i-c
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                //如果需要组成的金额正好和某个硬币的面额相等
                if (i == coin) {
                    dp[i] = 1;
                } else {
                    //只有能凑成dp[i - coin]才能凑成dp[i]
                    if (dp[i - coin] != 0) {
                        //暂时能凑成dp[i-coin]，但是凑不成dp[i]，那么直接将dp[i-coin]+1
                        //既能凑成dp[i-coin]，又能凑成dp[i]，那么取dp[i-coin]+1和dp[i]的较小值
                        dp[i] = dp[i] == 0 ? dp[i - coin] + 1 : Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }


    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i >= c) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
