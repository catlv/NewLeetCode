package topic101_200;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 */
public class LC137 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        //i代表第几位，由于int最大为2的31次方，所以总共有32位
        for (int i = 0; i < 32; i++) {
            //count求的是此时位置上1的个数
            int count = 0;
            //最开始要求二进制中第一个位置1的个数，所以通过和 0001 进行与操作来得到
            //第二个位置就要和 0010 进行与操作才行，所以是 1<<i
            int index = 1 << i;
            for (int n : nums) {
                if ((index & n) != 0) {
                    count++;
                }
            }
            //如果1的个数除以3的余数为1，表示此时遇到的就是只出现一次的那个数，这个数此时二进制位置的数就为1
            if (count % 3 == 1) {
                res |= index;
            }
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int n : nums) {
            ones = ones ^ n & ~twos;
            twos = twos ^ n & ~ones;
        }
        return ones;
    }
}
