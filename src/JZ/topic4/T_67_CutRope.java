package JZ.topic4;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 思路：尽量分解出多的3，设3的个数为a，得到的余数为b，b可能的取值为0,1,2
 * b==0，返回3的a次方
 * b==1，末尾为4，2 + 2 优于 3 + 1，因此返回 (3 的 a-1 次方) * 4
 * b==2，末尾为5，分解出3，还剩2，因此返回 (3 的 a 次方) * 2
 */
public class T_67_CutRope {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        }
        return (int) (Math.pow(3, a) * 2);
    }
}
