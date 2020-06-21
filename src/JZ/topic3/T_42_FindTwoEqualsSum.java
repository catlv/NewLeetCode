package JZ.topic3;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class T_42_FindTwoEqualsSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int s = array[i] + array[j];
            if (s == sum) {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            } else if (s < sum) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
