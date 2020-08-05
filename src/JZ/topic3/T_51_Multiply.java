package JZ.topic3;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 思路：
 * 首先res[i]分别赋值为A[0],A[0]A[1],A[0]A[1]A[2]...A[0]~A[n-1]
 * 也就是先计算下三角形，再乘以上三角形。
 */
public class T_51_Multiply {
    public static int[] multiply(int[] a) {
        int n = a.length;
        if (n == 0) {
            return new int[0];
        }
        int[] res = new int[n];
        int temp = 1;
        res[0] = 1;
        //下三角形第一个为1，所以循环时从i=1开始，跳过i=0
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        //上三角形是一个倒立的三角形，最底下那行只有一个数，为1，所以从i=n-2开始
        for (int i = n - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i] *= temp;
        }
        return res;
    }
}
