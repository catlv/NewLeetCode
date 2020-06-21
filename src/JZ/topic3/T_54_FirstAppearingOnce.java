package JZ.topic3;

import java.util.HashMap;

public class T_54_FirstAppearingOnce {
    HashMap<Character, Integer> map = new HashMap<>();
    StringBuffer s = new StringBuffer();

    public void Insert(char ch) {
        s.append(ch);
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    public char FirstAppearingOnce() {
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return '#';
    }
}
