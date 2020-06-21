package JZ.topic1;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * toCharArray 是指将字符串（String）转换为字符数组，而不是StringBuffer
 * 此处是StringBuffer，所以要用 str.charAt(i)
 *
 * 对于空格，使用 ' '，而不能用 " "
 */
public class T_02_ReplaceAll {
    public String replaceSpace(StringBuffer str) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') { // 或 String.valueOf(c).equals(" ")
                s.append("%20");
            } else {
                s.append(c);
            }
        }
        return s.toString();
        //return String.valueOf(s);
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are person");
        T_02_ReplaceAll t = new T_02_ReplaceAll();
        String res = t.replaceSpace(str);
        System.out.println(res);

        char c = '2';
        String r1 = String.valueOf(c);

        String d = "2或222ddd";
        String r2 = d.toString();
        String r3 = String.valueOf(d);
        boolean isB = r2.equals(r3); //true
        boolean isB2 = d.equals(r2); //true
    }
}
