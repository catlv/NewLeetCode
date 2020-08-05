package JZ.topic3;

import java.util.ArrayList;

/**
 * 思路：通过举例可以得出第一次删除的数字下标为(m-1)%n,记为index，之后每一次删除的数字下标均为(index+m-1)%list.size()
 */
public class T_46_LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
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
