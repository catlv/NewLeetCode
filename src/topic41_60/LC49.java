package topic41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 思路：
 * 想对 strs 中的每一个字符串进行排序，比如 acb 排序为 abc，需要三步操作：
 * char[] c = str.toCharArray();
 * Arrays.sort(c);
 * String sortStr = String.valueOf(c);
 */
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortStr = String.valueOf(c);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, i++);
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
            } else {
                //map.get(sortStr)表示获得map中key为sortStr的value值，即i值
                //i值表示的是res中的第i个list
                res.get(map.get(sortStr)).add(str);
            }
        }
        return res;
    }
}
