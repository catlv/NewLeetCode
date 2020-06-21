package topic1_20;

/**
 * 整数转换为罗马数字
 * I   1
 * V   5
 * X   10
 * L   50
 * C   100
 * D   500
 * M   1000
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 思路：
 * 对于罗马数字，一般都是左边的数大于等于右边的数，比如III，VII等
 * 但有特殊情况左边的数小于右边的数，IV，IX，XL，XC，CD，CM
 * 加上基本情况：I,V,X,L,C,D,M
 * 总共有13种，按从小到大构成 String[] s
 */
public class LC12 {
    public String intToRoman(int num) {
        String[] s = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder sb = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i--) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(s[i]);
            }
        }
        return sb.toString();
    }
}
