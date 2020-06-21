package JZ.topic3;

/**
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 * 思路：先反转前n个数，再反转后面剩余的数，最后整个反转。
 */
public class T_43_LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] c = str.toCharArray();
        reverse(c, 0, n - 1);
        reverse(c, n, str.length() - 1);
        reverse(c, 0, str.length() - 1);
        return String.valueOf(c);
    }

    private void reverse(char[] c, int l, int r) {
        for (int i = l, j = r; i <= j; i++, j--) {
            char a = c[i];
            c[i] = c[j];
            c[j] = a;
        }
    }

    public String LeftRotateString2(String str, int n) {
        int len = str.length();
        if (len == 0) {
            return str;
        }
        n %= len;
        //字符串分割，尾部不包括
        String s1 = str.substring(0, n);
        String s2 = str.substring(n, len);
        return s2 + s1;
    }
}