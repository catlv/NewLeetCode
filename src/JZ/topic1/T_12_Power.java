package JZ.topic1;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class T_12_Power {
    //非递归方式
    public double Power(double base, int exponent) {
        double res = 1;
        int temp = exponent;
        if (exponent < 0) {
            exponent = -exponent;
        }
        for (int i = 1; i <= exponent; i++) {
            res *= base;
        }
        return temp < 0 ? 1 / res : res;
    }

    //递归方式
    public double getTheResult(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else {
            double res = getTheResult(base, exponent >> 1);
            res *= res;
            if (exponent % 2 == 1) {
                return res * base;
            }
            return res;
        }
    }

    public double Power2(double base, int exponent) {
        boolean isNegetive = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegetive = true;
        }
        double result = getTheResult(base, exponent);
        if (isNegetive) {
            return 1 / result;
        } else {
            return result;
        }
    }
}
