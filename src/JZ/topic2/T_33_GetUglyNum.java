package JZ.topic2;

import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

public class T_33_GetUglyNum {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] res = new int[index + 1];
        int count = 0, i2 = 0, i3 = 0, i5 = 0;
        res[0] = 1;
        while (count < index) {
            int temp = Math.min(res[i2] * 2, Math.min(res[i3] * 3, res[i5] * 5));
            if (temp == res[i2] * 2) {
                i2++;
            }
            if (temp == res[i3] * 3) {
                i3++;
            }
            if (temp == res[i5] * 5) {
                i5++;
            }
            res[++count] = temp;
        }
        return res[index - 1];
    }

    //用链表。由于是查找第index个丑数，所以用数组效率会更高
    public int GetUglyNumber_Solution2(int index) {
        if (index == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index) {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2) i2++;
            if (min == m3) i3++;
            if (min == m5) i5++;
        }
        return list.get(list.size() - 1);
    }
}
