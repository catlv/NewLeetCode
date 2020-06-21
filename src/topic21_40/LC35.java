package topic21_40;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。数组中无重复元素。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
