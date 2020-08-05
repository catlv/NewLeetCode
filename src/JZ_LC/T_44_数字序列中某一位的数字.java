package JZ_LC;

public class T_44_数字序列中某一位的数字 {
    public int findNthDigit(int n) {
        if (n < 10)
            return n;
        int i = 1;
        while (n > i * (Math.pow(10, i - 1)) * 9) {   //循环结束后,i-1就是位数,n-1为表示还要找多少个
            n -= i * Math.pow(10, i - 1) * 9;
            i++;
        }
        char[] result = String.valueOf((int) Math.pow(10, i - 1) + (n - 1) / i).toCharArray();//我们用字符串来接收值，方便找位数 result结果为我们要的那个数的
        return result[(n - 1) % i] - '0';
    }

    public static void main(String[] args) {
        T_44_数字序列中某一位的数字 t = new T_44_数字序列中某一位的数字();
        int res = t.findNthDigit(18);
        System.out.println(res);
    }
}
