package JZ_LC;

import java.util.HashMap;

public class T_50_第一个只出现一次的字符 {
    //数组（效率高）。字符的ASCII码总共有256个。
    public char firstUniqChar(String s) {
        int[] nums = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            nums[c]++;
        }
        for (char c : chars) {
            if (nums[c] == 1) {
                return c;
            }
        }
        return ' ';
    }


    //hashMap
    public char firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
