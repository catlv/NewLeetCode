package topic101_200;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 */
public class LC137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        //i代表第几位
        for (int i = 0; i < 32; i++) {
            //每一位上1的个数
            int count = 0;
            for (int n : nums) {
                //数组中的数n的二进制的第i位是否为1
                if ((n >> i & 1) == 1) {
                    count++;
                }
            }
            //整列的1的个数是否是3的倍数，不是的话就将res二进制的这位置下标设为1
            if (count % 3 != 0) {
                //此处先计算的 1 << i 。 表示将res的第i位置为1
                res = res | 1 << i;
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
