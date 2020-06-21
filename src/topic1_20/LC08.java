package topic1_20;

/**
 * 将字符串转换成整型
 * 要求：去除空格，判断正负，如果后面存在非数字或全为空则返回0；
 * 数字后还存有非数字则忽略；
 * 如果超过int表示范围，则根据正负返回INT_MAX 或 INT_MIN。
 * Input: "   -42"
 * Output: -42
 *
 * Input: "4193 with words" 数字后还存有非数字则忽略
 * Output: 4193
 *
 * Input: "words and 987" 正负后面存在非数字或全为空则返回0
 * Output: 0
 *
 * Input: "-91283472332"
 * Output: -2147483648
 */
public class LC08 {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        int start = 0;
        int sign = 1;
        long res = 0;
        str = str.trim();
        if (str.charAt(0) == '+') {
            start++;
        }
        if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) res * sign;
    }
}
