package JZ.topic3;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 思路：
 * 首先res[i]分别赋值为A[0],A[0]A[1],A[0]A[1]A[2]...A[0]~A[n-1]
 * 也就是先计算下三角形，再乘以上三角形。
 */
public class T_51_Multiply {
    public static int[] multiply(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int temp = 1;
        for (int i = 0; i < n; i++) {
            res[i] = temp;
            temp *= A[i];
        }
        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= A[i];
        }
        return res;
    }
}
