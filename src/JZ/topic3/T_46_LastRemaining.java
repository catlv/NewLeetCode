package JZ.topic3;

import java.util.LinkedList;

/**
 * n个人，编号分别为0~n-1，第一个人从0开始报数，报到m-1时退出，接着下一个人再从0开始报数，
 * 也报到m-1时退出。如此循环，求出最后那个人的编号。
 * 思路：找到一个m-1位置后，删除元素，然后index-1，也就是后移一位，接着再向前走m步，然后对list取模。
 */
public class T_46_LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = -1;
        while (list.size() > 1) {
            index = (index + m) % list.size();
            list.remove(index);
            index--; //每次加m的时候，实际要加的是m-1
        }
        return list.get(0);
    }
}
