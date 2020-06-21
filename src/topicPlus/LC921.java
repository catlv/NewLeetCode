package topicPlus;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号，以使得到的括号字符串有效。
 * '(' 设为 A，')'设为 B。    A、B可以放在任何位置
 * 思路：
 * count 表示当前A与B的差值， A 就加1，B 就减1
 * res++ 表示当B比A多时，res+1，也就是添加了一个A
 * count++ 表示由于前面添加了一个A，所以A与B的差值也要加1
 * res + count 表示总共添加的A，加上A与B的差值。
 */
public class LC921 {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '(' ? 1 : -1;
            if (count == -1) {
                res++;
                count++;
            }
        }
        return res + count;
    }
}
