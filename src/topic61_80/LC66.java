package topic61_80;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 1024 -> 1025
 * 1099 -> 1100
 * 9999 -> 10000
 */
public class LC66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; //两个return只有一个会执行
            } else {
                digits[i] = 0;
            }
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        LC66 t = new LC66();
        int[] d = {9, 9};
        int[] res = t.plusOne(d);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
