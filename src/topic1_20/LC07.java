package topic1_20;

/**
 * 反转整数
 * Input: 123
 * Output: 321
 *
 * Input: -123
 * Output: -321
 */
public class LC07 {
    public int reverse(int x) {
        long res = 0; //用int的话翻转后可能溢出，比如1999999999（-2147483648~2147483647）
        while (x != 0) {
            res = res * 10 + x % 10; //x=123，x%10=3， x/=10  x为12
            x /= 10;
            //当它的逆序整型数溢出的话，返回 0
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                res = 0;
            }
        }
        return (int) res;
    }

    //方法二：不用long
    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            if ((temp - x % 10) / 10 != res) { //相等表示未发生溢出
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }
}
