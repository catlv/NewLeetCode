package JZ.topic3;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * long是长整型，int是整型，str.charAt()是字符型
 * 由 str.charAt()-'0' 即可得到此字符型对应的整型了
 */
public class T_49_StrToInt {
    public int StrToInt(String str) {
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
                return 0;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return 0;
            }
            if (sign == -1 && -res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) res * sign;
    }
}
