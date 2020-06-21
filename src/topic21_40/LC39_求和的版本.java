package topic21_40;
/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 回溯法
 */

import java.util.ArrayList;
import java.util.List;

public class LC39_求和的版本 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int target, int start) {
        int sum = 0;
        for (int c : list) {
            sum += c;
        }
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) { //剪枝
                continue;
            }
            list.add(candidates[i]);
            helper(res, list, candidates, target, i);
            list.remove(list.size() - 1);
        }
    }
}
