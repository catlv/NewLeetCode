package topic41_60;
/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class LC50 {
    public double myPow(double x, int n) {
        if (n < 0) {
            return helper(1 / x, -n);
        } else {
            return helper(x, n);
        }
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double d = helper(x, n / 2);
        if (n % 2 == 0) {
            return d * d;
        } else {
            return d * d * x;
        }
    }
}
