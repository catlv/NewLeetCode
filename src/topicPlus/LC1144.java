package topicPlus;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * <p>
 * 复制操作：Arrays.copyOf(nums,nums.length)
 */
public class LC1144 {
    public int movesToMakeZigzag(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                continue;
            }
            if (i == 0) {
                count1 += nums[i] >= nums[i + 1] ? nums[i] - nums[i + 1] + 1 : 0;
            } else if (i == nums.length - 1) {
                count1 += nums[i] >= nums[i - 1] ? nums[i] - nums[i - 1] + 1 : 0;
            } else {
                int min = Math.min(nums[i - 1], nums[i + 1]);
                count1 += nums[i] >= min ? nums[i] - min + 1 : 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                continue;
            }

            if (i == nums.length - 1) {
                count2 += nums[i] >= nums[i - 1] ? nums[i] - nums[i - 1] + 1 : 0;
            } else {
                int min = Math.min(nums[i - 1], nums[i + 1]);
                count2 += nums[i] >= min ? nums[i] - min + 1 : 0;
            }
        }
        return Math.min(count1, count2);
    }

    public int movesToMakeZigzag2(int[] nums) {
        // 偶数索引大于相邻元素
        int resEven = evenNums(Arrays.copyOf(nums, nums.length));
        // 为0，就表示已经是锯齿数组了，就没必要计算奇数索引的情况了
        if (resEven == 0) {
            return 0;
        }

        // 奇数索引大于相邻元素
        int resOdd = oddNums(nums);
        if (resOdd == 0) {
            return 0;
        } else {
            return Math.min(resEven, resOdd);
        }
    }

    //偶数索引大于相邻元素 所需要的最小操作次数
    private int evenNums(int[] nums) {
        return getOpts(nums, 0);
    }

    //奇数索引大于相邻元素 所需要的最小操作次数
    private int oddNums(int[] nums) {
        return getOpts(nums, 1);
    }

    /**
     * 跟相邻的元素比较
     */
    private int getOpts(int[] nums, int startIndex) {
        int tmpOpt = 0;
        int len = nums.length;
        for (int i = startIndex; i < len; i += 2) {
            //因为比较式中有nums[i-1]，所以 i - 1 >= 0
            if (i - 1 >= 0 && nums[i] <= nums[i - 1]) {
                int curtOpt = nums[i - 1] - nums[i] + 1;
                tmpOpt += curtOpt;
                nums[i - 1] -= curtOpt;
            }
            //因为比较式中有nums[i+1]，所以 i + 1 < len
            if (i + 1 < len && nums[i] <= nums[i + 1]) {
                int curtOpt = nums[i + 1] - nums[i] + 1;
                tmpOpt += curtOpt;
                nums[i + 1] -= curtOpt;
            }
        }
        return tmpOpt;
    }
}
