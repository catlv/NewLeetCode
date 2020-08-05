package topicPlus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LC442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        return list;
    }

    public static void main(String[] args) {
        LC442 t = new LC442();
        int[] nums = {2, 2, 2, 1, 1, 3};
        List<Integer> res = t.findDuplicates(nums);
        System.out.println(res);
    }
}
