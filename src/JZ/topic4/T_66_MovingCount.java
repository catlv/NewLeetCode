package JZ.topic4;

public class T_66_MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold == 0) {
            return 1;
        }
        int flag[][] = new int[rows][cols];
        return count(threshold, rows, cols, 0, 0, flag);
    }

    private int count(int threshold, int rows, int cols, int i, int j, int[][] flag) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || sum(i) + sum(j) > threshold || flag[i][j] == 1) {
            return 0;
        }
        flag[i][j] = 1;
        return 1 + count(threshold, rows, cols, i - 1, j, flag) + count(threshold, rows, cols, i + 1, j, flag) + count(threshold, rows, cols, i, j - 1, flag) + count(threshold, rows, cols, i, j + 1, flag);
    }

    private int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += i % 10; // '%':求余数
            i /= 10; // '/':商的整数
        }
        return s;
    }
}
