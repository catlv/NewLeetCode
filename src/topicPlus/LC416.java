package topicPlus;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 :
 * 输入: [1, 5, 11, 5]
 * 输出: true，数组可以分割成 [1, 5, 5] 和 [11].
 */
public class LC416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;

        // dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
        //之所以是target+1，是因为下面的for循环中，j的范围是[0,target]
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正

                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else if (nums[i] == j) {
                    dp[i][j] = true;
                } else if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }

    //dp空间优化
    public boolean canPartition2(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if (total % 2 == 1) {
            return false;
        }
        total = total / 2;
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = total; i >= n; i--) {
                dp[i] = dp[i] || dp[i - n];
            }
        }
        return dp[total];
    }
}
