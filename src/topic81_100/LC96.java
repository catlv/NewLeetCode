package topic81_100;

/**
 * 假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
 * G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)
 * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
 * f(i) = G(i-1)*G(n-i)
 * 所以 G(n) = G(0)∗G(n−1) + G(1)∗(n−2) +...+ G(n−1)∗G(0)
 * 所以 dp[n] = dp[j] * dp[n-j-1]
 */
public class LC96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - j - 1];

        return dp[n];
    }
}
