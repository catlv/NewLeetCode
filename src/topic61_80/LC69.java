package topic61_80;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 */
public class LC69 {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) (mid + 1);
            } else {
                high = (int) (mid - 1);
            }
        }
        return high;
    }
}