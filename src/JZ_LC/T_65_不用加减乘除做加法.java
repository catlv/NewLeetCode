package JZ_LC;

/**
 * 以13+9位例
 * 13 = 1101   9 = 1001
 * 1.计算不进位的和：1101 ^ 1001 = 0100 （异或）
 * 2.计算进位，它们对应位置上的数都为1时，那么为1，再向左移动一位，就可以得到进位的情形了：
 * (1101 & 1001) <<1 ，首先得到1001,1表示要进位的位置，然后左移得到 10010
 * 3.接下来需要计算 10010 和 0100 的和，它们和的结果就是答案。此处计算和同样不能用加法，所以是套娃，再来一次
 * 4.对新值 0100 和 10010 先异或得到一个值，再与操作后左移又得到一个值，重新套娃，直到与操作左移的那个值为0，也就是没有进位了。
 */
public class T_65_不用加减乘除做加法 {
    public int add(int a, int b) {
        //下面a和b的顺序可以交换
        while (b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }
}
