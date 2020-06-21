package topic1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 三数之和，用的是类似 LC01 两数之和的方法，复杂度很高，不推荐。
 */
public class LC15s {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                int c = -a - b;
                if (map.containsKey(c)) {
                    res.add(Arrays.asList(a, b, c));
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) { //去重
                        j++;
                    }
                }
                map.put(nums[j], j);
            }
        }
        return res;
    }
}
