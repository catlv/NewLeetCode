package JZ.topic1;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class T_19_PrintMatrix {
    //非递归（比递归代码少10行）
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bot = matrix.length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bot; i++) {
                res.add(matrix[i][right]);
            }

            if (top != bot) {
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[bot][i]);
                }
            }

            if (left != right) {
                for (int i = bot - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }

            top++;
            bot--;
            left++;
            right--;
        }
        return res;
    }

    //左神 递归
    public ArrayList<Integer> printMatrix2(int[][] matrix) {
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        ArrayList<Integer> list = new ArrayList<>();
        while (left <= right && top <= bottom) {
            list = printEdge(matrix, top++, left++, bottom--, right--, list);
        }
        return list;
    }

    public static ArrayList<Integer> printEdge(int[][] m, int top, int left, int bottom, int right, ArrayList list) {
        if (top == bottom) {
            for (int i = left; i <= right; i++) {
                list.add(m[top][i]);
            }
        } else if (left == right) {
            for (int i = top; i <= bottom; i++) {
                list.add(m[i][left]);
            }
        } else {
            int curC = left;
            int curR = top;
            while (curC != right) {
                list.add(m[top][curC]);
                curC++;
            }
            while (curR != bottom) {
                list.add(m[curR][right]);
                curR++;
            }
            while (curC != left) {
                list.add(m[bottom][curC]);
                curC--;
            }
            while (curR != top) {
                list.add(m[curR][left]);
                curR--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        T_19_PrintMatrix t = new T_19_PrintMatrix();
        ArrayList<Integer> res = t.printMatrix(matrix);
        System.out.println(res);

        ArrayList<Integer> res2 = t.printMatrix2(matrix);
        System.out.println(res2);
    }
}
