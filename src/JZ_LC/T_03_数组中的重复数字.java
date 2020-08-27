package JZ_LC;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class T_03_数组中的重复数字 {
    //原题目要求返回的是int
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    //返回的是List
    public List<Integer> findRepeatNumber2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    list.add(nums[i]);
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        T_03_数组中的重复数字 t = new T_03_数组中的重复数字();
        int[] nums = {2, 2, 3, 3};
        int res = t.findRepeatNumber(nums);
        System.out.println(res);
    }
}
