package JZ.topic2;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 */
public class T_31_NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int res = 0;
        // base表示当前判断的位数、cur表示当前位、height表示高位
        int base = 1;
        int cur;
        int height = n;
        while (height > 0) {
            cur = height % 10;
            height /= 10;
            res += height * base; //先加上一开始的
            if (cur == 1) { //如果是计算2的出现次数，此处就改为2
                res += (n % base) + 1; //==1 就要看前面的了
            } else if (cur > 1) { //如果是计算2的出现次数，此处就改为2
                res += base; //后面剩的，>1 还要+base
            }
            base *= 10;
        }
        return res;
    }
}
