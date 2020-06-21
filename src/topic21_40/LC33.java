package topic21_40;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * (例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 ，输出: 4
 * <p>
 * 思路：如果中间的数比左面的数大的话，那么左半部分序列是递增的，否则右半部分就是递增的
 */
public class LC33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) { //这类题优先判断相等的情况
                return mid;
            } else if (nums[mid] >= nums[l]) { //中>左，左半部分是递增的
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { //中<左，右半部分是递增的
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}