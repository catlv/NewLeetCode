package topic41_60;

/**
 * 缺失的第一个正数:给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 解题思路
 * 设数组长度为n。
 * 数组中可能出现了小于0，等于0或者大于数组长度n的值。
 * <p>
 * 若n为3，正整数排列应该为[1,2,3]，但是现在出现了负数，0，大于n的数，那么必然 1 2 3中会有数缺失。
 * 针对这种情况，我们只需要看看数组中小于n的数，都有哪些，就能确定缺失的最小正数了。
 * <p>
 * 也就是说，我们不在乎数组中出现的负数，0，大于n的数。
 * 如果你们在数组中，那么缺失的最小正数必然小于n。
 * 如果你们都不在数组中，那么缺失的最小正数就是n+1
 * <p>
 * 第一遍遍历：我们将小于等于0或者大于数组长度n的数给一个特殊标记，但是吧，它还得是数，于是就MAX_VALUE。
 * 第二遍遍历：我们将出现的元素nums[i]对应数组第i个位置的数置为负数，来表征出现过nums[i]这个数，在这个过程中遇到了特殊标记MAX_VALUE直接跳过。
 * 第三遍遍历：来康康数组中第i个元素是不是负的，第i个是负的说明出现过i这个数。如果发现第i个数是正的数，那么说明i这个数从未出现，他就是我们要找的数。注：第三遍遍历都结束了，还没有出现正数，那就意味着这个数组是[1,2,3]这样的完全包含n个正整数的数组，那么n+1就是我们要找的正整数。
 */
public class LC41 {
    public int firstMissingPositive(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) == Integer.MAX_VALUE) {
                continue;
            }
            int consider = Math.abs(nums[i]);
            if (nums[consider - 1] > 0) {
                nums[consider - 1] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
