package topic21_40;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 回溯法
 * 《无重复元素，无限次使用》
 */

import java.util.ArrayList;
import java.util.List;

public class LC39_s1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) { //剪枝
                continue;
            }
            list.add(candidates[i]);
            help(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
