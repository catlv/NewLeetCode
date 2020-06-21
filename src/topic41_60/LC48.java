package topic41_60;
/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 思路:对于  1  2  3  4         13  9   5  1
 *           5  6  7  8         14  10  6  2
 *           9  10 11 12   ——>  15  11  7  3
 *           13 14 15 16        16  12  8  4
 *     colEnd - colStart = 3 ，而根据上面情况可知，逆时针每个外圈需要交换3次，1和4换，2和8换，3和12换...
 *     然后rowStart++, colStart++, rowEnd--, colEnd--，进入第二个外圈   6  7
 *                                                                   10 11
 */
public class LC48 {
    public void rotate(int[][] matrix) {
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        while (rowStart < rowEnd) { //每循环一次就进入一层内圈
            helper(matrix, rowStart++, colStart++, rowEnd--, colEnd--);
        }
    }

    private void helper(int[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd) {
        int times = colEnd - colStart;
        int temp;
        for (int i = 0; i < times; i++) {
            temp = matrix[rowStart][colStart + i];
            matrix[rowStart][colStart + i] = matrix[rowEnd - i][colStart];
            matrix[rowEnd - i][colStart] = matrix[rowEnd][colEnd - i];
            matrix[rowEnd][colEnd - i] = matrix[rowStart + i][colEnd];
            matrix[rowStart + i][colEnd] = temp;
        }
    }
}
