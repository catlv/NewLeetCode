package JZ.topic3;

import java.util.HashMap;

public class T_50_Duplicate {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0 || numbers == null) {
            return false;
        }
        boolean[] used = new boolean[length];
        for (int n : numbers) {
            if (used[n]) {
                duplication[0] = n;
                return true;
            }
            used[n] = true;
        }
        return false;
    }

    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                map.put(numbers[i], 0);
            }
        }
        return false;
    }
}
