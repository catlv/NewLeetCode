package JZ.topic1;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * <p>
 * 动态规划：
 * 1.定义数组元素含义
 * 2.找出关系式
 * 3.找出初始条件
 */
public class T_08_JumpFloor {
    public int JumpFloor(int target) {
//        dp法：
//        if (target <= 2) {
//            return target;
//        }
//        int[] dp = new int[target + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= target; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[target];

        //dp空间优化
        if (target <= 2) {
            return target;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= target; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
