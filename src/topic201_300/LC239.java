package topic201_300;

import java.util.Scanner;

/**
 * 在机器学习中有一种流行的池化操作，而在池化操作中，3*3极大值池化应用十分广泛。什么是3*3极大值池化呢？设原矩阵是n*m的，则3*3极大值池化就是枚举矩阵中的所有3*3的子矩阵,分别求最大值并顺次拼接而成，处理过后的矩阵是(n-2)*(m-2)。
 *
 * 例如，原矩阵是[[1,2,3,4],[5,6,7,8],[9,10,11,12]],经过池化之后就变成[[11,12]]。
 *
 * 为了提高难度，选择的滑动窗口并不是3*3的，而是a*b的，由于输入可能是非常大的，原n*m的矩阵权值由以下公式计算得到，h(i,j)=i*j mod 10。(1<=i<=n,1<=j<=m)
 *
 * 由于输出矩阵也是一个很麻烦的事情，因此你只需输出经过a*b池化处理后的矩阵的元素之和即可。
 *
 * 输入：输入第一行包含四个正整数，n,m,a,b，分别表示原矩阵的行列数量和滑动窗口的行列数量。(1<=n,m,a,b<=1000)
 * 输出：输出仅包含一个整数，即新矩阵的元素之和。
 * 4 5 3 3
 * 54
 *
 * 西西所在的国家有N座城市，每座城市都有一道传送门，城市 i 的传送门通往城市 a[i]。当西西位于城市 i 时，每次他可以执行以下三种操作中的一种：
 *
 *   花费 A 的费用，从城市 i 前往城市 a[i]；
 *
 *   如果 a[i] > 1，可以花费 B 的费用，将 a[i] 的值减少 1；
 *
 *   如果 a[i] < N，可以花费 C 的费用，将 a[i] 的值增加 1。
 *
 * 现在，西西想从城市 1 前往城市 N，那么他至少要花费多少费用？
 *
 * 输入：
 * 第一行输入四个整数 N、A、B、C（1 < N <= 10000，1 <= A、B、C <= 100000）。
 *
 * 第二行输入 N 个整数 a[1] 到 a[N]（1 <= a[i] <= N）。
 *
 * 输出：一个整数，表示从城市 1 前往城市 N 所花费的最少费用。
 * 7  1  1  1
 * 3  6  4  3  4  5  6
 *
 * 4
 */
public class LC239 {
    public static int maxNum(int[][] nums, int a, int b) {
        int n = nums.length;
        int m = nums[0].length;
        int temp = 0;
        int ii = n - a;
        int jj = m - b;
        int max = Integer.MIN_VALUE;

        for (int jjj = 0; jjj <= ii; jjj++) {
            for (int jjjj = 0; jjjj <= jj; jjjj++) {
                for (int i = ii; i < ii + a; i++) {
                    for (int j = jj; j < jj + b; j++) {
                        max = Math.max(max, nums[i][j]);
                    }
                }
                temp += max;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (n < a || n < b || a > 1000 || b > 1000) {
            System.out.println(0);
        } else {
            int[][] nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = ((i + 1) * (j + 1)) % 10;
                }
            }
            int res = maxNum(nums, a, b);
            System.out.println(res);
        }
    }
}
