package JZ.topic2;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 */
public class T_31_NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1;
        int res = 0;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += high * digit + digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
