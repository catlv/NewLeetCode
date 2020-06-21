package topic41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个有重复数字的序列，返回所有不重复的全排列。
 * 思路：回溯法。
 * 1.由于有重复数字，所以先排序
 * 2.去重，如果第i个数等于第i-1个数，而第i-1个数又用过了，则直接continue
 */
public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
