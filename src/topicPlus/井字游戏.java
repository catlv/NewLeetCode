package topicPlus;

/**
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * 以下是井字游戏的规则：
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 示例：
 * 输入： board = ["O X"," XO","X O"]
 * O X
 * XO
 * X O
 * 输出： "X"
 * <p>
 * 输入： board = ["OOX","XXO","OX "]
 * OOX
 * XXO
 * OX
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * <p>
 * 思路：
 * 题意是类似快照模式的问法，也就是不会动态的插入O或X
 * 所以只需要进行全面的循环和判断即可。判断每一行 每一列 2次斜线
 */
public class 井字游戏 {
    public String tictactoe(String[] board) {
        int len = board.length;
        //当有一行一列时，对应该字符的玩家获胜
        if (len == 1) {
            return board[0];
        }
        //是否有空格
        boolean flag = false;
        char s = ' ';

        //行
        //判断每行ok不，ok就直接返回赢家，否则就记录是否有空格
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                s = board[i].charAt(j);
                if (j + 1 < len) {
                    if (s != board[i].charAt(j + 1)) {
                        break;
                    }
                    if (s == ' ') {
                        flag = true;
                        break;
                    }
                }
                if (j == len - 1) {
                    return String.valueOf(s);
                }
            }
        }

        //列
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                s = board[j].charAt(i);
                if (j + 1 < len) {
                    if (s != board[j + 1].charAt(i)) {
                        break;
                    }
                    if (s == ' ') {
                        flag = true;
                        break;
                    }
                }
                if (j == len - 1) {
                    return String.valueOf(s);
                }
            }
        }

        //斜: 斜线分为左斜线和右斜线
        //左斜线
        for (int i = 0; i < len; ++i) {
            s = board[i].charAt(i);
            if (i + 1 < len) {
                if (s != board[i + 1].charAt(i + 1)) {
                    break;
                }
                if (s == ' ') {
                    flag = true;
                    break;
                }
            }
            if (i == len - 1) {
                return String.valueOf(s);
            }
        }

        //右斜线
        for (int i = len - 1, j = 0; i >= 0 && j < len; i--, j++) {
            s = board[i].charAt(j);
            if (i >= 1 && j < len - 1) {
                if (s != board[i - 1].charAt(j + 1)) {
                    break;
                }
                if (s == ' ') {
                    flag = true;
                    break;
                }
            }
            if (i == 0 && j == len - 1) {
                return String.valueOf(s);
            }
        }

        //如果程序走到了这样，表示目前还没有玩家获胜
        //如果前面的判断中有空格，则返回pending等待，可以理解为此时在中场休息。否则平局。
        if (flag) {
            return "Pending";
        }
        return "Draw";
    }
}
