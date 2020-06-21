package topic1_20;

/**
 * 给定一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c，使得a + b + c = 0？找出所有满足条件且不重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *     [-1, 0, 1],
 *     [-1, -1, 2]
 * ]
 * 注意：Arrays.sort() 这里 sort 是小写。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //去重，比如-1,-1,0,1,2,2,4，第一步从-1开始时，计算的是第一个-1和后面{-1,0,1,2,4}中能组成0的两数
            //而从第二个-1开始时，计算的是第二个-1和后面{0,1,2,4}中能组成0的两数
            //很显然第一步已经包含了第二步可能的情况了，所以直接continue
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = i + 1;
            int b = nums.length - 1;
            while (a < b) {
                if (nums[i] + nums[a] + nums[b] == 0) {
                    res.add(Arrays.asList(nums[i], nums[a], nums[b]));
                    while (a < b && nums[a] == nums[a + 1]) { //去重
                        a++;
                    }
                    while (a < b && nums[b] == nums[b - 1]) { //去重
                        b--;
                    }
                    a++;
                    b--;
                } else if (nums[i] + nums[a] + nums[b] > 0) {
                    b--;
                } else {
                    a++;
                }
            }
        }
        return res;
    }
}
