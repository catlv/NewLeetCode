package JZ.topic1;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 解答：一个整数n的二进制数为1100，n-1对应的二进制数是1011，n&(n-1)为1000，count数加1，判断出了其中的一个1，如此往复。
 *
 * n &= (n - 1) 的作用可以理解成：将 n 这个数的二进制表示中，最右边的一个1给去掉。
 */
public class T_11_NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 0;
        T_11_NumberOf1 t = new T_11_NumberOf1();
        int res = t.NumberOf1(n);
        System.out.println(res);
    }
}
