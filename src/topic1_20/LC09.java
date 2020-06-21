package topic1_20;

/**
 * 判断是否是回文数
 * Input: 121
 * Output: true
 *
 * Input: -121
 * Output: false
 */
public class LC09 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int rev = 0;
        while (x > 0) { //此处不能写成 x>=0 ，会无限循环
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return temp == rev;
    }
}
