package JZ_LC;

/**
 * trim方法去掉的是最开始的空格，而不是中间的空格！！
 * int的取值范围要牢记：-2^31——2^31-1，即-2147483648——2147483647
 */
public class T_67_把字符串转换为整数 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) { //注意要在开始处带上这种判断
            return 0;
        }
        int res = 0;
        int flag = 1;
        if (str.charAt(0) == '-') {
            flag = -1;
            str = str.substring(1); //如果开始位置为'+'或'-'，那么要进行substring处理
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                int temp = str.charAt(i) - '0';
                //如果例子是-2147483647，则在最后一步判断尾部的7时，不会进去这里的if语句中，而是求得res，循环结束，输出-res
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + temp;
            } else {
                break;
            }
        }
        return res * flag;
    }
}
