package topic1_20;

/**
 * Z字形变换：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列，然后从左往右逐行读取，产生出一个新的字符串。
 */
public class LC06 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int curRow = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            sb[curRow].append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                down = !down;
            }
            if (down) {
                curRow += 1;
            } else {
                curRow -= 1;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : sb) {
            res.append(row);
        }
        return res.toString();
    }
}
