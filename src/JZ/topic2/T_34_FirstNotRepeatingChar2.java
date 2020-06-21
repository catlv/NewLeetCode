package JZ.topic2;

public class T_34_FirstNotRepeatingChar2 {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if (len == 0) {
            return -1;
        }
        char[] s = str.toCharArray();
        int[] m = new int[256];
        for (int i = 0; i < len; i++) {
            m[s[i]]++;
        }
        for (int i = 0; i < len; i++) {
            if (m[s[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
