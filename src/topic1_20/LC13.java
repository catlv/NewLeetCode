package topic1_20;

import java.util.HashMap;

/**
 * 罗马数字转换为整数，范围为1~3999。
 * I   1
 * V   5
 * X   10
 * L   50
 * C   100
 * D   500
 * M   1000
 * <p>
 * Input: "MCMXCIV"
 * 1000 100 1000 10 100 1 5
 * M    C   M   X   C  I V
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 5-1+100-10+1000-100+1000=1994
 * 即从末尾len-1处往头看，左<右时，‘左’处的值相对于整体需要被减去，左不小于右时，整体加上它即可
 * 首先sum等于末尾处的值5，然后左边I<右边V，整体需要减去I，于是sum-=I
 * 然后左边C>I，sum加上C即可
 * 然后左边X<C，sum-=X   依此类推
 */
public class LC13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
