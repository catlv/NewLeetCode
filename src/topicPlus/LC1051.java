package topicPlus;

import java.util.Arrays;

public class LC1051 {
    public int heightChecker(int[] heights) {
        int[] tmp = Arrays.copyOf(heights, heights.length);
        //int[] tmp = heights.clone();
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (tmp[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

    public int heightChecker_100(int[] heights) {
        int[] arr = new int[101];
        for (int h : heights) {
            arr[h]++;
        }
        int count = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (i != heights[j]) {
                    count++;
                }
                arr[i]--;
                j++;
            }
        }
        return count;
    }
}
