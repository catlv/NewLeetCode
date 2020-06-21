package topic61_80;

/**
 * 一个机器人位于一个 m x n 网格的左上角。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 问总共有多少条不同的路径？
 *
 * 步骤一：定义数组元素的含义：当机器人从左上角走到(i,j) 这个位置时，一共有dp[i][j]种路径。
 * 那么，dp[m-1][n-1] 就是我们要的答案了。
 *
 * 步骤二：找出关系式：dp[i][j] = dp[i-1][j] + dp[i][j-1]。
 *
 * 步骤三：找出初始值：由于步骤二中i-1和j-1的存在，所以如果i或j有一个为0，就不能使用关系式了。
 * 所以初始值需要计算出所有的 dp[0][0….n-1] 和所有的 dp[0….m-1][0]。
 */
public class LC62 {
    public int uniquePaths(int m, int n) {
        //dp法：
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

        //dp空间优化，m x n 优化成 1 x n
//        if (m <= 0 || n <= 0) {
//            return 0;
//        }
//        //dp[0..n-1]表示第一行的值
//        int[] dp = new int[n];
//        //初始化，第一行的值都为1
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//        }
//        //关系式：dp[i] = dp[i-1] + dp[i]
//        for (int i = 1; i < m; i++) {
//            //第i行第0列的初始值为1
//            dp[0] = 1;
//            for (int j = 1; j < n; j++) {
//                dp[j] = dp[j - 1] + dp[j];
//            }
//        }
//        return dp[n - 1];
    }
}
