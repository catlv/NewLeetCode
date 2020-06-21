package topic21_40;

/**
 * 给定一个按照升序排列的整数数组nums，和一个目标值target。找出给定目标值在数组中的开始位置和结束位置。
 * 思路：首先二分法找到这个目标值，然后围绕这个目标值向左向右寻找和它相同的值，它们也相邻。
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
                while (i > start && nums[i] == nums[i - 1]) {
                    i--;
                }
                while (j < end && nums[j] == nums[j + 1]) {
                    j++;
                }
                return new int[]{i, j};
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}