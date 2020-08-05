package JZ_LC;

/**
 * 注意不能用双重for循环，会超时
 * 这里采用双指针法
 */
public class T_57_和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[2];

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                res[0] = nums[l];
                res[1] = nums[r];
                return res;
            }
        }
        return res;
    }
}
