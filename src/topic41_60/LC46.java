package topic41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列(整数)，返回其所有可能的全排列。
 */
public class LC46 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
