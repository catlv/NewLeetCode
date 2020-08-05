package JZ_LC;

/**
 * 先计算下三角形，再计算上三角形
 */
public class T_66_构建乘积数组 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) {
            return new int[0];
        }
        int[] b = new int[n];
        b[0] = 1;
        int tmp = 1;
        //下三角形第一个为1，所以循环时从i=1开始，跳过i=0
        for (int i = 1; i < n; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //上三角形是一个倒立的三角形，最底下那行只有一个数，为1，所以从i=n-2开始
        for (int i = n - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
