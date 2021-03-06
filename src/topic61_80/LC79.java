package topic61_80;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中,单词必须按照字母顺序，通过相邻的单元格内的字母构成
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class LC79 {
    private boolean[][] b;

    public boolean exist(char[][] board, String word) {
        b = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int start) {
        if (start > word.length() - 1) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || b[i][j]) {
            return false;
        }

        if (board[i][j] == word.charAt(start++)) {
            b[i][j] = true; //true表示已经用过了
            boolean res = helper(board, word, i + 1, j, start) || helper(board, word, i, j + 1, start) || helper(board, word, i - 1, j, start) || helper(board, word, i, j - 1, start);
            b[i][j] = false; //回退成没用过的状态
            return res;
        }
        return false;
    }
}
