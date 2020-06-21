package topic101_200;

import java.util.HashMap;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 思路：采用异或来解决。a ^ b ^ a = a ^ a ^ b = 0 ^ b = b
 */
public class LC136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

    //hash方法（不推荐）
    public int singleNumberHash(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.remove(n);
            } else {
                map.put(n, 1);
            }
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            res = key;
        }
        return res;
    }
}
