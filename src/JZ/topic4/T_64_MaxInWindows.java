package JZ.topic4;

import java.util.ArrayList;

public class T_64_MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if (size == 0 || len < size) {
            return res;
        }
        for (int i = 0; i <= len - size; i++) {
            int max = num[i];
            for (int j = i + 1; j < size + i; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            res.add(max);
        }
        return res;
    }
}
