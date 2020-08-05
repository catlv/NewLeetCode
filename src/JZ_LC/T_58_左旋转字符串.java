package JZ_LC;

public class T_58_左旋转字符串 {
    //substring，效率最高，推荐
    public String reverseLeftWords(String s, int n) {
        if (s.length() == 0)
            return s;
        return s.substring(n) + s.substring(0, n);
    }

    //先旋转前n和数，再旋转后面的数，最后整体旋转
    public String reverseLeftWords2(String s, int n) {
        char[] c = s.toCharArray();
        int len = s.length();
        reverse(c, 0, n - 1);
        reverse(c, n, len - 1);
        reverse(c, 0, len - 1);
        return String.valueOf(c);
    }

    private void reverse(char[] c, int l, int r) {
        for (int i = l, j = r; i <= j; i++, j--) {
            char a = c[i];
            c[i] = c[j];
            c[j] = a;
        }
    }

    public static void main(String[] args) {
        String s = "abcdef";
        T_58_左旋转字符串 t = new T_58_左旋转字符串();
        String res = t.reverseLeftWords(s, 2);
        System.out.println(res);
    }
}
