package topicPlus;

import java.util.Arrays;
import java.util.HashSet;

/**
 *  反转字符串中的元音字母
 */
public class LC345 {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = s.length() - 1;
        char[] res = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                res[i++] = ci;
            } else if (!vowels.contains(cj)) {
                res[j--] = cj;
            } else {
                res[i++] = cj;
                res[j--] = ci;
            }
        }
        return String.valueOf(res);
    }
}
