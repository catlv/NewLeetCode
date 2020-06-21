package topic41_60;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class LC56_int {
    public int[][] merge(int[][] arrs) {
        if (arrs == null || arrs.length == 0) {
            return arrs;
        }
        //按每行的第一位从小到大排列
        Arrays.sort(arrs, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        int start = arrs[0][0];
        int end = arrs[0][1];
        for (int[] arr : arrs) {
            if (arr[0] <= end) {
                end = Math.max(arr[1], end);
            } else {
                list.add(new int[]{start, end});
                start = arr[0];
                end = arr[1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][2]);
    }
}
