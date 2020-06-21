package topicPlus;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * <p>
 * 输入: [0,1,3]  长度为3，则n=4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 思路：
 * 由于是排序过的，所以用二分查找
 */
public class 面试题53 {
    public int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) { //是否需要加等于号，可以设置nums = [0] 这个例子来判断
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
