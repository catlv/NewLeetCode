package JZ_LC;

import java.util.ArrayList;

/**
 * 思路：通过举例可以得出第一次删除的数字下标为(m-1)%n,记为index，之后每一次删除的数字下标均为(index+m-1)%list.size()
 * 0 1 2 3 4      m = 3
 * 结果为：2 0 4 1 3
 */
public class T_62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
