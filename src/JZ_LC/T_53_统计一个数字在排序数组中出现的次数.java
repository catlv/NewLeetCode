package JZ_LC;

import java.util.Arrays;

/**
 * 计算target出现的右边界，和 target-1 出现的右边界
 * 它们的差值就是target出现的次数
 * <p>
 * 最开始要是 while (l <= r)
 * mid与目标值之间的判断分为下面几种情况：
 * mid < target   返回l   得到的是左边第一个等于target的下标    返回r   得到的是左边第一个小于target的下标
 * mid <= target  返回r   得到的是右边第一个等于target的下标    返回l   得到的是右边第一个大于target的下标
 */
public class T_53_统计一个数字在排序数组中出现的次数 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int l2 = 0;
        int r2 = nums.length - 1;
        while (l2 <= r2) {
            int mid = l2 + (r2 - l2) / 2;
            if (nums[mid] <= target) {
                l2 = mid + 1;
            } else {
                r2 = mid - 1;
            }
        }

        return r2 - l + 1;
    }

    //递归巧妙写法
    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        int target = 2;
        T_53_统计一个数字在排序数组中出现的次数 t = new T_53_统计一个数字在排序数组中出现的次数();
        int res = t.helper(nums, target);
        System.out.println(res);
    }

    //函数式编程写法
    public int search3(int[] nums, int target) {
        return (int) Arrays.stream(nums)
                .filter(e -> e == target)
                .count();
    }
}
