package topicPlus;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例一:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 *
 * 示例二:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。存在两个值为2的数，它们都排第二。
 *
 * 注意点：最开始定义two和three时，不能写成 int two = Integer.MIN_VALUE;
 * 因为 Integer.MIN_VALUE 的值为 -2147483648 ，同样可能是这个数组中的数
 * 所以要选择取值范围大于 Integer 的 Long 的最小值。也就是 long two = Long.MIN_VALUE;
 */
public class LC414 {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int one = nums[0];
        long two = Long.MIN_VALUE;
        long three = Long.MIN_VALUE;

        for (int n : nums) {
            if (n == one || n == two || n == three) {
                continue;  // 如果存在过,就跳过
            }
            if (n > one) {
                three = two;
                two = one;
                one = n;
            } else if (n > two) {
                three = two;
                two = n;
            } else if (n > three) {
                three = n;
            }
        }
        return three == Long.MIN_VALUE ? one : (int) three; // 没有第三大的元素，就返回最大值
    }
}
