package JZ_LC;

public class T_39_数组中出现次数超过一半的元素 {
    public int majorityElement(int[] nums) {
        //使用工具类的方法
        //Arrays.sort(nums);
        //int res = nums[(nums.length - 1) / 2];

        //投票法，效率最高，推荐
        //设众数为 res，设票数为 votes，当票数 votes 为0时，将数组中此时位置的数设为众数，接下来的数组中的数，如果等于众数，票数就加1，不等于众数则减一。当票数变为0时，就重新设置当前位置的数为众数，如此反复。最后的众数即为结果。
        int votes = 0;
        int res = 0;
        for (int a : nums) {
            if (votes == 0) {
                res = a;
            }
            votes += a == res ? 1 : -1;
        }

        int count = 0;
        for (int n : nums) {
            if (n == res) {
                count++;
            }
        }
        if (count * 2 > nums.length) {
            return res;
        }
        return 0;
    }
}
